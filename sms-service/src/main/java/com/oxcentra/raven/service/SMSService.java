package com.oxcentra.raven.service;

import com.oxcentra.raven.bean.Payload;
import com.oxcentra.raven.bean.SMSResponse;
import reactor.core.publisher.Mono;

public interface SMSService {
    Mono<SMSResponse> sendSMS(Payload payload);
}
