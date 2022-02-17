package com.oxcentra.raven.service;

import com.oxcentra.raven.bean.Payload;
import com.oxcentra.raven.bean.SMSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
public class SMSServiceImpl implements SMSService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSServiceImpl.class);



    @Override
    public Mono<SMSResponse> sendSMS(Payload payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8762/storage-service/save/payload"; // send to storage-service
        HttpEntity<Payload> requestEntity = new HttpEntity<Payload>(payload,headers);
        ResponseEntity<SMSResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, SMSResponse.class );

        return Mono.just(responseEntity.getBody());
    }
}
