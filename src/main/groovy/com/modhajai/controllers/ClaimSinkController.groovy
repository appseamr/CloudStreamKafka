package com.modhajai.controllers

import com.modhajai.config.Csink
import com.modhajai.models.PatientEvent
import com.modhajai.repositories.PatientEventRepository
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jaimodha on 2/26/17.
 */
@RestController
@Component
@EnableBinding(Csink.class)
class ClaimSinkController {

    @Autowired
    Csink csink

    @Autowired
    PatientEventRepository patientEventRepository

    String output

    @StreamListener(Csink.INPUT)
    void receive(String response) {
        output = response
    }

    @RequestMapping('/receiveClaim')
    def receiveController() {
        patientEventRepository.save(new JsonSlurper().parseText(output) as PatientEvent)
        return output
    }

}
