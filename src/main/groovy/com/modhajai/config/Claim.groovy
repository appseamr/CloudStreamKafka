package com.modhajai.config

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

/**
 * Created by jaimodha on 2/26/17.
 */
interface Claim {

    String OUTPUT = "claim";

    @Output(Claim.OUTPUT)
    MessageChannel output()

}