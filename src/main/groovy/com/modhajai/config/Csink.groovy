package com.modhajai.config

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.messaging.SubscribableChannel

/**
 * Created by jaimodha on 2/26/17.
 */
interface Csink {

    String INPUT = "claim";

    @Input(Sink.INPUT)
    SubscribableChannel input();

}