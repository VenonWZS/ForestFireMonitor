package com.bjfu.forestfiremonitor.entity;

import java.util.Date;

public class Video {
    private Integer vidid;

    private String vidname;

    private Date vidstarttime;

    private String vipurl;

    private String vidskchimgurl;

    private Integer vidtype;

    private Integer mptid;

    private Integer userid;

    public Integer getVidid() {
        return vidid;
    }

    public void setVidid(Integer vidid) {
        this.vidid = vidid;
    }

    public String getVidname() {
        return vidname;
    }

    public void setVidname(String vidname) {
        this.vidname = vidname == null ? null : vidname.trim();
    }

    public Date getVidstarttime() {
        return vidstarttime;
    }

    public void setVidstarttime(Date vidstarttime) {
        this.vidstarttime = vidstarttime;
    }

    public String getVipurl() {
        return vipurl;
    }

    public void setVipurl(String vipurl) {
        this.vipurl = vipurl == null ? null : vipurl.trim();
    }

    public String getVidskchimgurl() {
        return vidskchimgurl;
    }

    public void setVidskchimgurl(String vidskchimgurl) {
        this.vidskchimgurl = vidskchimgurl == null ? null : vidskchimgurl.trim();
    }

    public Integer getVidtype() {
        return vidtype;
    }

    public void setVidtype(Integer vidtype) {
        this.vidtype = vidtype;
    }

    public Integer getMptid() {
        return mptid;
    }

    public void setMptid(Integer mptid) {
        this.mptid = mptid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}