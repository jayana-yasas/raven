package com.oxcentra.raven.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Contacts {
    private int contactId;
    private String mobile;
    private String email;
    private String name;
    private String status;
    private String tags;
    private String campaignIds;
    private Timestamp lastupdateddate;

    @Id
    @Column(name = "contact_id")
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Basic
    @Column(name = "campaign_ids")
    public String getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(String campaignIds) {
        this.campaignIds = campaignIds;
    }

    @Basic
    @Column(name = "lastupdateddate")
    public Timestamp getLastupdateddate() {
        return lastupdateddate;
    }

    public void setLastupdateddate(Timestamp lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return contactId == contacts.contactId &&
                Objects.equals(mobile, contacts.mobile) &&
                Objects.equals(email, contacts.email) &&
                Objects.equals(name, contacts.name) &&
                Objects.equals(status, contacts.status) &&
                Objects.equals(tags, contacts.tags) &&
                Objects.equals(campaignIds, contacts.campaignIds) &&
                Objects.equals(lastupdateddate, contacts.lastupdateddate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactId, mobile, email, name, status, tags, campaignIds, lastupdateddate);
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contactId=" + contactId +
                ", mobile='" + mobile + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
