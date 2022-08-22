package com.jpumpkin.hospitalapi.domain.patient.repository

import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import org.springframework.data.jpa.repository.JpaRepository

interface PatientRepository: JpaRepository<Patient, Long> {
}