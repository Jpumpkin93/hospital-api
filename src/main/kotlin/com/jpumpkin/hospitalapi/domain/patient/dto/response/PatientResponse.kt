package com.jpumpkin.hospitalapi.domain.patient.dto.response

import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import java.time.LocalDateTime

data class PatientResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val name: String,
    val registerNumber: String,
    val genderCode: String,
    val dateOfBirth: String,
    val mobileNumber: String?,
    val hospitalId: Long,
    val visitList: List<VisitResponse>
) {
    companion object {
        fun from(patient: Patient) = PatientResponse(
            id = patient.id!!,
            createdAt = patient.createdAt!!,
            name = patient.name,
            registerNumber = patient.registerNumber,
            genderCode = patient.genderCode,
            dateOfBirth = patient.dateOfBirth,
            mobileNumber = patient.mobileNumber,
            hospitalId = patient.hospital.id!!,
            visitList = patient.visitList.map { VisitResponse.from(it) }
        )
    }
}