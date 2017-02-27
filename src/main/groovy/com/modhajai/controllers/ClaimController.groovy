package com.modhajai.controllers

import com.modhajai.config.Claim
import com.modhajai.models.PatientEvent
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Source
import org.springframework.integration.support.MessageBuilder
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jaimodha on 2/26/17.
 */
@RestController
@Component
@EnableBinding(Claim.class)
class ClaimController {

    @Autowired
    Claim claim

    @PostMapping('/claim')
    def sendClaim() {
        PatientEvent patientEvent = new PatientEvent()
        patientEvent.with {
            eventType = 'CLAIM'
            eventData = """
            ST*270*1234*005010X279A1~
            """.stripIndent()
        }
        claim.output().send(MessageBuilder.withPayload(new JsonBuilder(patientEvent).toString()).build())
    }

}
