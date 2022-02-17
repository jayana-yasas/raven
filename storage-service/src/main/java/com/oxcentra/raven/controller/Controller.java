package com.oxcentra.raven.controller;


import com.oxcentra.raven.bean.Payload;
import com.oxcentra.raven.bean.SMSResponse;
import com.oxcentra.raven.entity.Contacts;
import com.oxcentra.raven.service.SMSCampaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    SMSCampaign smsCampaign;

    @PostMapping("/test")
    public ResponseEntity<SMSResponse> sendSMS(@Param("tags") String tags){

        SMSResponse smsResponse= new SMSResponse();
        smsResponse.setStatus("1");
        smsResponse.setReference_id(String.valueOf(System.currentTimeMillis()));

        for (Contacts contacts : smsCampaign.findByTagsLike(tags)) {
            System.out.println(contacts.getMobile());
            smsResponse.setStatus_des(smsResponse.getStatus_des()+","+contacts.getMobile());
        }

        return new ResponseEntity<SMSResponse>(smsResponse, HttpStatus.OK) ;



    }
}
