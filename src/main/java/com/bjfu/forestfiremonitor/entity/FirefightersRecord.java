package com.bjfu.forestfiremonitor.entity;

public class FirefightersRecord {
    private Integer arecid;

    private String userid;

    private Double xlocation;

    private Double ylocation;

    public Integer getArecid() {
        return arecid;
    }

    public void setArecid(Integer arecid) {
        this.arecid = arecid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Double getXlocation() {
        return xlocation;
    }

    public void setXlocation(Double xlocation) {
        this.xlocation = xlocation;
    }

    public Double getYlocation() {
        return ylocation;
    }

    public void setYlocation(Double ylocation) {
        this.ylocation = ylocation;
    }
}