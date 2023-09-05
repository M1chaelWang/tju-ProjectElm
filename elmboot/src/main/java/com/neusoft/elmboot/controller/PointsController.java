package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.po.Points;
import com.neusoft.elmboot.service.PointsService;

@RestController
@RequestMapping("/PointsController")
public class PointsController {
    @Autowired
    private PointsService pointsService;

    @RequestMapping("/listPointsByOrderUserId")
    public List<Points> listPointsByOrderUserId(Points points) throws Exception {
        return pointsService.listPointsByOrderUserId(points.getUserId());
    }

    @RequestMapping("/savePoints")
    public int savePoints(Points points) throws Exception {
        return pointsService.savePoints(points);
    }

    @RequestMapping("/updatePoints")
    public void updatePoints(Integer pointId, Integer point) throws Exception {
        pointsService.updatePoints(pointId, point);
    }

    @RequestMapping("/removePoints")
    public void removePoints(Points points) throws Exception {
        pointsService.removePoints(points.getPointId());
    }

}
