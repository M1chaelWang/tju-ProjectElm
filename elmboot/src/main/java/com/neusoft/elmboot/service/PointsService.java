package com.neusoft.elmboot.service;

import java.util.List;
import com.neusoft.elmboot.po.Points;

public interface PointsService {

    public List<Points> listPointsByOrderUserId(String userId);

    public int savePoints(Points points);

    public void updatePoints(Integer pointId, Integer point);

    public void removePoints(Integer pointId);

}
