package com.oxcentra.raven;

import com.oxcentra.raven.process.SMSCampaignEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
//@EnableEurekaClient\
public class StorageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StorageApplication.class, args);

        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");

        SMSCampaignEvent smsCampaignEvent = context.getBean(SMSCampaignEvent.class);
        taskExecutor.execute(smsCampaignEvent);

    }


    @PostMapping("/test")
    public ResponseEntity<String> test( ){
        return new ResponseEntity<String>("Welcome test", HttpStatus.OK) ;
    }
    @PostMapping("/methord")
    public ResponseEntity<String> methord( ){
        return new ResponseEntity<String>("Welcome methord", HttpStatus.OK) ;
    }

}
