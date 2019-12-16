package com.bjfu.forestfiremonitor.entity;

public class User {
    private String userid;

    private String username;

    private String userpwd;

    private Integer userright;

    private String usermail;

    private String userphone;

    private String userdept;

    private String emptime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Integer getUserright() {
        return userright;
    }

    public void setUserright(Integer userright) {
        this.userright = userright;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUserdept() {
        return userdept;
    }

    public void setUserdept(String userdept) {
        this.userdept = userdept == null ? null : userdept.trim();
    }

    public String getEmptime() {
        return emptime;
    }

    public void setEmptime(String emptime) {
        this.emptime = emptime == null ? null : emptime.trim();
    }
}