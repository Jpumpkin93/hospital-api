package com.jpumpkin.hospitalapi.domain.hospital.repository

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
internal class HospitalRepositoryTest {

    @Autowired
    lateinit var hospitalRepository: HospitalRepository

    @Test
    fun `병원을 저장한다`() {
        val hospital = Hospital(
            name = "jpumpkin병원",
            institutionNumber = "01",
            directorName = "박정호"
        )

        hospitalRepository.save(hospital)
    }

}