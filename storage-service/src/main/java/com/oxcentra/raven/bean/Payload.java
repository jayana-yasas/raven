package com.oxcentra.raven.bean;

import java.util.Arrays;

public class Payload  {
    private String apikey;
    private int clientId;
    private String sourceAddress;
    private String[] destinations;
    private Content content;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String[] getDestinations() {
        return destinations;
    }

    public void setDestinations(String[] destinations) {
        this.destinations = destinations;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    @Override
    public String toString() {
        return "Payload{" +
                "apikey='" + apikey + '\'' +
                ", clientId=" + clientId +
                ", sourceAddress='" + sourceAddress + '\'' +
//                ", destinations=" + Arrays.toString(destinations) +
                ", content=" + content +
                '}';
    }
}
