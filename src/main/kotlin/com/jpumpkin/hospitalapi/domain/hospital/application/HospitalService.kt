package com.jpumpkin.hospitalapi.domain.hospital.application

import com.jpumpkin.hospitalapi.domain.hospital.dto.request.CreateHospitalRequest
import com.jpumpkin.hospitalapi.domain.hospital.repository.HospitalRepository
import org.springframework.stereotype.Service


@Service
class HospitalService(
    val hospitalRepository: HospitalRepository
) {
    fun createHospital(request: CreateHospitalRequest) {
        hospitalRepository.save(request.toEntity())
    }
}