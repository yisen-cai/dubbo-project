package com.qunar.training.utils;

import java.io.Serializable;

/**
 * @author YISHEN CAI
 */
public class OkResult implements Serializable {

    private String msg;


    public OkResult(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
