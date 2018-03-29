package com.trapeze.RuntimeUnitCatalog.Protocol;

/**
 * Created by user on 2018-03-30.
 */
public class ReturnValue {

    int status;

    String message;

    public ReturnValue(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
