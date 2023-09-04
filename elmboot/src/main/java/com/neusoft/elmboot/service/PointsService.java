package com.neusoft.elmboot.service;

import java.util.List;
import com.neusoft.elmboot.po.Points;

public interface PointsService {

    public List<Points> listPointsByOrderUserId(String userId);

    public int savePoints(Points points);

    public int updatePoints(String userId, Integer point);

    public int removePoints(Integer pointId);

}
