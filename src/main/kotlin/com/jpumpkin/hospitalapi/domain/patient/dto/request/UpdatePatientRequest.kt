package com.jpumpkin.hospitalapi.domain.patient.dto.request

import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdatePatientRequest(
    @field:Size(max = 45)
    @field:NotBlank
    val name: String,

    @field:Size(max = 10)
    @field:NotBlank
    val genderCode: String,

    @field:Size(max = 10)
    @field:NotBlank
    val dateOfBirth: String,

    @field:Size(max = 20)
    @field:NotBlank
    val mobileNumber: String?
) {
    fun toEntity(patient: Patient) = Patient(
        name = this.name,
        registerNumber = patient.registerNumber,
        genderCode = this.genderCode,
        dateOfBirth = this.dateOfBirth,
        mobileNumber = this.mobileNumber,
        hospital = patient.hospital
    )

}