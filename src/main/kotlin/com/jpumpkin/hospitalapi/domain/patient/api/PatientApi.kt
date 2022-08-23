package com.jpumpkin.hospitalapi.domain.patient.api

import com.jpumpkin.hospitalapi.domain.patient.application.PatientService
import com.jpumpkin.hospitalapi.domain.patient.dto.request.CreatePatientRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.request.PatientVisitRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.request.UpdatePatientRequest
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
class PatientApi(
    val patientService: PatientService
) {

    @PostMapping("/patients")
    fun createPatient(
        @Valid @RequestBody request: CreatePatientRequest
    ) = ok(patientService.createPatient(request))

    @PutMapping("/patients/{id}")
    fun updatePatient(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdatePatientRequest
    ) = ok(patientService.updatePatient(id, request))

    @DeleteMapping("/patients/{id}")
    fun deletePatient(
        @PathVariable id: Long
    ) = ok(patientService.deletePatient(id))

    @GetMapping("/patients/{id}")
    fun getPatient(
        @PathVariable id: Long
    ) = ok(patientService.getPatient(id))

    @GetMapping("/patients")
    fun getPatientList(
        @RequestParam name: String?,
        @RequestParam registerNumber: String?,
        @RequestParam dateOfBirth: String?,
    ) = ok(patientService.getPatientList(name, registerNumber, dateOfBirth))

    @PostMapping("/patients/{id}/visit")
    fun visit(
        @PathVariable id: Long,
        @Valid @RequestBody request: PatientVisitRequest
    ) = ok(patientService.visit(id, request))
}