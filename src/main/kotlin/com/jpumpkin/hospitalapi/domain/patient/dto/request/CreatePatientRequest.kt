package com.jpumpkin.hospitalapi.domain.patient.dto.request

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreatePatientRequest(
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
    val mobileNumber: String?,

    @field:NotNull
    val hospitalId: Long
) {

    fun toEntity(hospital: Hospital) = Patient(
        name = this.name,
        registerNumber = generateRegisterNumber(hospital),
        genderCode = this.genderCode,
        dateOfBirth = this.dateOfBirth,
        mobileNumber = this.mobileNumber,
        hospital = hospital
    )

    private fun generateRegisterNumber(hospital: Hospital) = "${hospital.id}_${dateOfBirth}_${name}"
}