package com.oxcentra.raven.process;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxcentra.raven.entity.SmsCampaign;
import com.oxcentra.raven.repository.SmsSentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SMSTask {

    public String mobile;
    public String content;
    public String uuid;
    public SmsCampaign smsCampaign;

    public SMSTask() {
        super();
    }

    public SMSTask(String mobile,String content,String uuid, SmsCampaign smsCampaign){
        this.mobile = mobile;
        this.uuid = uuid;
        this.content = content;
        this.smsCampaign = smsCampaign;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SmsCampaign getSmsCampaign() {
        return smsCampaign;
    }

    public void setSmsCampaign(SmsCampaign smsCampaign) {
        this.smsCampaign = smsCampaign;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "SMSTask{" +
                "uuid='" + uuid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
