package com.jpumpkin.hospitalapi.domain.patient.dto.response

import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import java.time.LocalDateTime

data class PatientListResponse(
    val name: String,
    val registerNumber: String,
    val genderCode: String,
    val dateOfBirth: String,
    val mobileNumber: String?,
    val lastVisitDate: LocalDateTime?
) {

    companion object {
        fun from(patient: Patient) = PatientListResponse(
            name = patient.name,
            registerNumber = patient.registerNumber,
            genderCode = patient.genderCode,
            dateOfBirth = patient.dateOfBirth,
            mobileNumber = patient.mobileNumber,
            lastVisitDate = patient.visitList.maxByOrNull { it.createdAt!! }?.createdAt
        )
    }
}