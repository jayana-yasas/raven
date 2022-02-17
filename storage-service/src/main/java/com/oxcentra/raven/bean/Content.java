package com.oxcentra.raven.bean;

public class Content {
    private String encode;
    private String message;

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Content{" +
                "encode='" + encode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
