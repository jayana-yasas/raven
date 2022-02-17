package com.oxcentra.raven.controller;


import com.oxcentra.raven.bean.Payload;
import com.oxcentra.raven.bean.SMSResponse;
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
@RequestMapping("save")
public class PayloadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayloadController.class);

    @PostMapping("/payload")
    public ResponseEntity<SMSResponse> sendSMS(@RequestBody Payload payload){
        try {
            LOGGER.info("{}", payload);

            SMSResponse smsResponse= new SMSResponse();
            smsResponse.setStatus("1");
            smsResponse.setReference_id(String.valueOf(System.currentTimeMillis()));
            smsResponse.setStatus_des("COMPLETED");



            return new ResponseEntity<SMSResponse>(smsResponse, HttpStatus.OK) ;
        }catch (Exception ex){
            LOGGER.info("{}", ex);
            SMSResponse smsResponse = new SMSResponse();
            smsResponse.setStatus("2");
            smsResponse.setReference_id(String.valueOf(System.currentTimeMillis()));
            smsResponse.setStatus_des("ERROR");
            return new ResponseEntity<SMSResponse>(smsResponse, HttpStatus.OK) ;
        }


    }
}
