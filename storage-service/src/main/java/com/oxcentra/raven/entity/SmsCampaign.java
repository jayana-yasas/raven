package com.oxcentra.raven.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sms_campaign" )
public class SmsCampaign {
    private int campaignId;
    private String campaignName;
    private String senderName;
    private String contentTemplate;
    private String isUnicode;
    private String isUrlshortener;
    private String isSchedule;
    private Timestamp scheduleDatetime;
    private String status;
    private String tags;

    @Id
    @Column(name = "campaign_id")
    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
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
    @Column(name = "sender_name")
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Basic
    @Column(name = "content_template")
    public String getContentTemplate() {
        return contentTemplate;
    }

    public void setContentTemplate(String contentTemplate) {
        this.contentTemplate = contentTemplate;
    }

    @Basic
    @Column(name = "is_unicode")
    public String getIsUnicode() {
        return isUnicode;
    }

    public void setIsUnicode(String isUnicode) {
        this.isUnicode = isUnicode;
    }

    @Basic
    @Column(name = "is_urlshortener")
    public String getIsUrlshortener() {
        return isUrlshortener;
    }

    public void setIsUrlshortener(String isUrlshortener) {
        this.isUrlshortener = isUrlshortener;
    }

    @Basic
    @Column(name = "is_schedule")
    public String getIsSchedule() {
        return isSchedule;
    }

    public void setIsSchedule(String isSchedule) {
        this.isSchedule = isSchedule;
    }

    @Basic
    @Column(name = "schedule_datetime")
    public Timestamp getScheduleDatetime() {
        return scheduleDatetime;
    }

    public void setScheduleDatetime(Timestamp scheduleDatetime) {
        this.scheduleDatetime = scheduleDatetime;
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
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsCampaign that = (SmsCampaign) o;
        return campaignId == that.campaignId &&
                Objects.equals(campaignName, that.campaignName) &&
                Objects.equals(senderName, that.senderName) &&
                Objects.equals(contentTemplate, that.contentTemplate) &&
                Objects.equals(isUnicode, that.isUnicode) &&
                Objects.equals(isUrlshortener, that.isUrlshortener) &&
                Objects.equals(isSchedule, that.isSchedule) &&
                Objects.equals(scheduleDatetime, that.scheduleDatetime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(campaignId, campaignName, senderName, contentTemplate, isUnicode, isUrlshortener, isSchedule, scheduleDatetime, status, tags);
    }

    @Override
    public String toString() {
        return "SmsCampaign{" +
                "campaignId=" + campaignId +
                ", campaignName='" + campaignName + '\'' +
                ", status='" + status + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
