package com.example.smartcity.bean;

import java.io.Serializable;

public class InfoResult implements Serializable {
    /**
     * msg : 操作成功
     * code : 200
     * user : {"userId":1111828,"userName":"yufeng","nickName":"屿枫","email":"1596779123@163.com","phonenumber":"13049003014","sex":"0","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","idCard":"210882199807251656","balance":1000,"score":1000}
     */

    private String msg;
    private int code;
    private UserBean user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }


}
