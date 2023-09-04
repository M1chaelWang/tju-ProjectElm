package com.neusoft.elmboot.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.PointsMapper;
import com.neusoft.elmboot.po.Points;
import com.neusoft.elmboot.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService{
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
    public int updatePoints(String userId, Integer point) {
        return pointsMapper.updatePoints(userId, point);
    }

    @Override
    public int removePoints(Integer pointId) {
        return pointsMapper.removePoints(pointId);
    }
    
}
