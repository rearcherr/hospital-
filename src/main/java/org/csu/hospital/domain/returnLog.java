package org.csu.hospital.domain;

public class returnLog {
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
    public returnLog(int code,String token){
        this.code=code;
        this.token=token;
    }
    public returnLog(int code){
        this.code=code;
        this.token=null;
    }

}
