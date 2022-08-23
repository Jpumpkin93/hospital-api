package com.jpumpkin.hospitalapi.domain.patient

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import com.jpumpkin.hospitalapi.domain.patient.repository.PatientRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
internal class PatientRepositoryTest {

    @Autowired
    lateinit var patientRepository: PatientRepository

    @Test
    fun `환자를 저장한다`() {
        val hospital = Hospital(
            name = "jpumpkin병원",
            institutionNumber = "01",
            directorName = "박정호"
        )

        val patient = Patient(
            name = "박정호",
            registerNumber = "01",
            genderCode = "M",
            dateOfBirth = "1985-11-11",
            mobileNumber = "010-0000-0000",
            hospital = hospital,
            visitList = mutableListOf()
        )

        patientRepository.save(patient)
    }

}