package com.bjfu.forestfiremonitor.entity;

import java.util.Date;

public class Picture {
    private Integer imgid;

    private String imgname;

    private String imgres;

    private String imgskturl;

    private String imgurl;

    private Integer imgtype;

    private Date createtime;

    private Integer mptid;

    private Integer userid;

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public String getImgres() {
        return imgres;
    }

    public void setImgres(String imgres) {
        this.imgres = imgres == null ? null : imgres.trim();
    }

    public String getImgskturl() {
        return imgskturl;
    }

    public void setImgskturl(String imgskturl) {
        this.imgskturl = imgskturl == null ? null : imgskturl.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Integer getImgtype() {
        return imgtype;
    }

    public void setImgtype(Integer imgtype) {
        this.imgtype = imgtype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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