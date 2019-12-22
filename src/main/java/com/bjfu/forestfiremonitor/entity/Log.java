package com.bjfu.forestfiremonitor.entity;

public class Log {
    private Integer logid;

    private String logtime;

    private String loguserid;

    private String logcontent;

    private Integer logclass;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime == null ? null : logtime.trim();
    }

    public String getLoguserid() {
        return loguserid;
    }

    public void setLoguserid(String loguserid) {
        this.loguserid = loguserid == null ? null : loguserid.trim();
    }

    public String getLogcontent() {
        return logcontent;
    }

    public void setLogcontent(String logcontent) {
        this.logcontent = logcontent == null ? null : logcontent.trim();
    }

    public Integer getLogclass() {
        return logclass;
    }

    public void setLogclass(Integer logclass) {
        this.logclass = logclass;
    }
}