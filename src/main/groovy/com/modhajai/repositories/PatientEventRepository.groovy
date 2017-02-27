package com.modhajai.repositories

import com.modhajai.models.PatientEvent
import org.springframework.data.repository.CrudRepository

/**
 * Created by jaimodha on 2/27/17.
 */
interface PatientEventRepository extends CrudRepository<PatientEvent, Long> {

    List<PatientEvent> findByEventType(String eventName)

}