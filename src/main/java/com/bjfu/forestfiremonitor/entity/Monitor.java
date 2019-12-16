package com.bjfu.forestfiremonitor.entity;

public class Monitor {
    private Integer mptid;

    private String mptname;

    private String mptip;

    private Double height;

    private Integer poiid;

    public Integer getMptid() {
        return mptid;
    }

    public void setMptid(Integer mptid) {
        this.mptid = mptid;
    }

    public String getMptname() {
        return mptname;
    }

    public void setMptname(String mptname) {
        this.mptname = mptname == null ? null : mptname.trim();
    }

    public String getMptip() {
        return mptip;
    }

    public void setMptip(String mptip) {
        this.mptip = mptip == null ? null : mptip.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getPoiid() {
        return poiid;
    }

    public void setPoiid(Integer poiid) {
        this.poiid = poiid;
    }
}