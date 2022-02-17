package com.oxcentra.raven.bean;

public class SMSResponse {
    private String reference_id;
    private String status;
    private String status_des;

    public SMSResponse() {

    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_des() {
        return status_des;
    }

    public void setStatus_des(String status_des) {
        this.status_des = status_des;
    }
}
