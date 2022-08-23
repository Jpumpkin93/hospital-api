package com.jpumpkin.hospitalapi.domain.patient.application

import com.jpumpkin.hospitalapi.domain.hospital.repository.HospitalRepository
import com.jpumpkin.hospitalapi.domain.patient.dto.request.CreatePatientRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.request.PatientVisitRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.request.UpdatePatientRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.response.PatientListResponse
import com.jpumpkin.hospitalapi.domain.patient.dto.response.PatientResponse
import com.jpumpkin.hospitalapi.domain.patient.repository.PatientQueryRepository
import com.jpumpkin.hospitalapi.domain.patient.repository.PatientRepository
import com.jpumpkin.hospitalapi.global.extension.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class PatientService(
    val patientRepository: PatientRepository,
    val patientQueryRepository: PatientQueryRepository,
    val hospitalRepository: HospitalRepository
) {

    @Transactional
    fun createPatient(request: CreatePatientRequest) {
        patientRepository.save(
            request.toEntity(hospitalRepository.findByIdOrThrow(request.hospitalId))
        )
    }

    @Transactional
    fun updatePatient(id: Long, request: UpdatePatientRequest) {
        patientRepository.findByIdOrThrow(id)
            .apply {
                update(request.toEntity(this))
            }
    }

    @Transactional
    fun deletePatient(id: Long) {
        patientRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    fun getPatient(id: Long) = PatientResponse.from(patientRepository.findByIdOrThrow(id))

    @Transactional(readOnly = true)
    fun getPatientList(name: String?, registerNumber: String?, dateOfBirth: String?) =
        patientQueryRepository.findAll(name, registerNumber, dateOfBirth)
            .map { PatientListResponse.from(it) }

    @Transactional
    fun visit(id: Long, request: PatientVisitRequest) {
        patientRepository.findByIdOrThrow(id)
            .apply {
                this.visit(request.statusCode)
            }
    }
}