package org.csu.hospital.domain;

public class ReturnLog {
    private int code;
    private String token;

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
    public ReturnLog(int code, String token){
        this.code=code;
        this.token=token;
    }
    public ReturnLog(int code){
        this.code=code;
        this.token=null;
    }

}
