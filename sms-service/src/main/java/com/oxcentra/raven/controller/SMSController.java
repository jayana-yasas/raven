package com.oxcentra.raven.controller;

import com.oxcentra.raven.bean.Payload;
import com.oxcentra.raven.bean.SMSResponse;
import com.oxcentra.raven.service.SMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class SMSController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSController.class);

    @Autowired
    SMSService smsService;

    @PostMapping("/sms")
    public ResponseEntity<SMSResponse> sendSMS(@RequestBody Payload payload){
        try {
            LOGGER.info("{}",payload);
            SMSResponse smsResponse = new SMSResponse();

            return new ResponseEntity<SMSResponse>(smsService.sendSMS(payload).block(), HttpStatus.OK) ;
        }catch (Exception ex){
            return new ResponseEntity<SMSResponse>(smsService.sendSMS(payload).block(), HttpStatus.OK) ;
        }


    }
}
