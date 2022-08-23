package com.jpumpkin.hospitalapi.domain.hospital.dto.request

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateHospitalRequest(
    @field:Size(max = 45)
    @field:NotBlank
    val name: String,

    @field:Size(max = 20)
    @field:NotBlank
    val institutionNumber: String,

    @field:Size(max = 10)
    @field:NotBlank
    val directorName: String
) {
    fun toEntity() = Hospital(
        name = this.name,
        institutionNumber = this.institutionNumber,
        directorName = this.directorName
    )
}