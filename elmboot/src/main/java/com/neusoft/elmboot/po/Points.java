package com.neusoft.elmboot.po;

public class Points {
    private Integer pointId;
    private String userId;
    private Integer point;
    private String date;

    public Integer getPointId() {
        return pointId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getPoint() {
        return point;
    }

    public String getDate() {
        return date;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
