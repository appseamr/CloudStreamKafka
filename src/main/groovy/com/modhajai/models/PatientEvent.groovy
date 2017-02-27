package com.modhajai.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by jaimodha on 2/26/17.
 */
@Entity
class PatientEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id
    String eventType
    String eventData

}
