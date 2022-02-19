package com.oxcentra.raven.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sms_sent", schema = "campaign", catalog = "")
public class SmsSent {
    private int id;
    private String uuid;
    private int campaignId;
    private String mobile;
    private String content;
    private String status;
    private String reference;
    private int clicks;
    private Timestamp createdtime;
    private String campaignName;
    private String telco;

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "campaign_id")
    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "clicks")
    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    @Basic
    @Column(name = "createdtime")
    public Timestamp getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Timestamp createdtime) {
        this.createdtime = createdtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsSent smsSent = (SmsSent) o;
        return id == smsSent.id &&
                campaignId == smsSent.campaignId &&
                clicks == smsSent.clicks &&
                Objects.equals(uuid, smsSent.uuid) &&
                Objects.equals(mobile, smsSent.mobile) &&
                Objects.equals(content, smsSent.content) &&
                Objects.equals(status, smsSent.status) &&
                Objects.equals(reference, smsSent.reference) &&
                Objects.equals(createdtime, smsSent.createdtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uuid, campaignId, mobile, content, status, reference, clicks, createdtime);
    }

    @Override
    public String toString() {
        return "SmsSent{" +
                "uuid='" + uuid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Basic
    @Column(name = "campaign_name")
    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    @Basic
    @Column(name = "telco")
    public String getTelco() {
        return telco;
    }

    public void setTelco(String telco) {
        this.telco = telco;
    }
}
