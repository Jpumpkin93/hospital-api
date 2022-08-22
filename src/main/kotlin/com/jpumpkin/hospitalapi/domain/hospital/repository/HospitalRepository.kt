package com.jpumpkin.hospitalapi.domain.hospital.repository

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import org.springframework.data.jpa.repository.JpaRepository

interface HospitalRepository: JpaRepository<Hospital, Long> {
}