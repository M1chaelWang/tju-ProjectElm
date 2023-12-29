package com.neusoft.elmboot.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.PointsMapper;
import com.neusoft.elmboot.po.Points;
import com.neusoft.elmboot.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService {
    @Autowired
    private PointsMapper pointsMapper;
    

    @Override
    public List<Points> listPointsByOrderUserId(String userId) {
        return pointsMapper.listPointsByOrderUserId(userId);
    }

    @Override
    public int savePoints(Points points) {
        return pointsMapper.savePoints(points);
    }

    @Override
    public void updatePoints(Integer pointId, Integer point) {
        pointsMapper.updatePoints(pointId, point);
    }

    @Override
    public void removePoints(Integer pointId) {
        pointsMapper.removePoints(pointId);
    }

    @Override
    public Boolean usePoints(String userId, Integer points) {
        int sum = sumValidPoint(userId);
        if (points > sum)
            return false;
        
        int tempPoints = points;
        List<Points> pointArr = new ArrayList<>();
        pointArr = listPointsByOrderUserId(userId);
        for (Points currentPoint : pointArr) {
            if (currentPoint.getValid() == 0)
                continue;

            tempPoints -= currentPoint.getPoint();
            if (tempPoints >= 0) {
                removePoints(currentPoint.getPointId());
                if (tempPoints == 0)
                    break;
            }
            else {
                updatePoints(currentPoint.getPointId(), -tempPoints);
            }
        }
        return true;
    }

    @Override
    public int sumValidPoint(String userId) {
        List<Points> pointArr = new ArrayList<>();
        pointArr = listPointsByOrderUserId(userId);
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date();
        int sum = 0;

        for (Points point : pointArr) {
            if (point.getValid() == 0)
                continue;
            String date = point.getDate();
            int year = Integer.valueOf(date.substring(0, 4));
            int month = Integer.valueOf(date.substring(date.indexOf("/") + 1, date.lastIndexOf("/")));
            int day = Integer.valueOf(date.substring(date.lastIndexOf("/") + 1, date.indexOf(" ")));
            int hour = Integer.valueOf(date.substring(date.indexOf(" ") + 1, date.indexOf(":")));
            int minute = Integer.valueOf(date.substring(date.indexOf(":") + 1, date.lastIndexOf(":")));
            int second = Integer.valueOf(date.substring(date.lastIndexOf(":") + 1, date.length()));
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1); // 月份从 0 开始，11 表示 12 月
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            calendar.set(Calendar.SECOND, second);
            Date recordDate = calendar.getTime();
            long timeDifference = currentDate.getTime() - recordDate.getTime();
            long hourDifference = timeDifference / (60 * 60 * 1000);

            if (hourDifference >= 3) {
                removePoints(point.getPointId());
            }
            else {
                sum += point.getPoint();
            }
        }
        return sum;
    }
}
