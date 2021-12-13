package com.example.smartcity.bean;

import java.io.Serializable;

public class Result implements Serializable {
    /**
     * msg : 操作成功
     * code : 200
     * token : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjkzMjBhYjA0LTBmYTgtNDZhYS04NzcwLWU2YTZlMDY5YzY3YyJ9.WDqC7ibCJWsG1e37qNFj3GY_FxJ3_pIH8MbFor_jcktju4Xx9CQHib6SyZcrQIbMIknVg-auWpGHsrLUSqGrcg
     */

    private String msg;
    private int code;
    private String token;

    public Result(String msg, int code, String token) {
        this.msg = msg;
        this.code = code;
        this.token = token;
    }

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", token='" + token + '\'' +
                '}';
    }
}
