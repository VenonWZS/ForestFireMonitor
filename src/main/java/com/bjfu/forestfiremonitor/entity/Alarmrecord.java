package com.bjfu.forestfiremonitor.entity;

import java.util.Date;

public class Alarmrecord {
    private Integer arecid;

    private Date alarmtime;

    private Double optlattitude;

    private Double optlongtitude;

    private Double optheight;

    private Integer isconfirm;

    private Integer ishandled;

    private Integer mptid;

    private Double hrzangle;

    public Date getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
    }

    private String userid;

    public Integer getArecid() {
        return arecid;
    }

    public void setArecid(Integer arecid) {
        this.arecid = arecid;
    }




    public Double getOptlattitude() {
        return optlattitude;
    }

    public void setOptlattitude(Double optlattitude) {
        this.optlattitude = optlattitude;
    }

    public Double getOptlongtitude() {
        return optlongtitude;
    }

    public void setOptlongtitude(Double optlongtitude) {
        this.optlongtitude = optlongtitude;
    }

    public Double getOptheight() {
        return optheight;
    }

    public void setOptheight(Double optheight) {
        this.optheight = optheight;
    }

    public Integer getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(Integer isconfirm) {
        this.isconfirm = isconfirm;
    }

    public Integer getIshandled() {
        return ishandled;
    }

    public void setIshandled(Integer ishandled) {
        this.ishandled = ishandled;
    }

    public Integer getMptid() {
        return mptid;
    }

    public void setMptid(Integer mptid) {
        this.mptid = mptid;
    }

    public Double getHrzangle() {
        return hrzangle;
    }

    public void setHrzangle(Double hrzangle) {
        this.hrzangle = hrzangle;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}