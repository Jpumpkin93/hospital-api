package com.jpumpkin.hospitalapi.domain.hospital.api

import com.jpumpkin.hospitalapi.domain.hospital.application.HospitalService
import com.jpumpkin.hospitalapi.domain.hospital.dto.request.CreateHospitalRequest
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
class HospitalApi(
    val hospitalService: HospitalService
) {

    @PostMapping("/hospitals")
    fun createHospital(
        @Valid @RequestBody request: CreateHospitalRequest
    ) = ok(hospitalService.createHospital(request))
}