package com.jpumpkin.hospitalapi.domain.hospital.application

import com.jpumpkin.hospitalapi.domain.hospital.dto.request.CreateHospitalRequest
import com.jpumpkin.hospitalapi.domain.hospital.repository.HospitalRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class HospitalServiceTest {

    @Autowired
    lateinit var hospitalRepository: HospitalRepository

    @Autowired
    lateinit var hospitalService: HospitalService

    @Test
    fun `병원을 생성한다`() {
        val request = CreateHospitalRequest(
            name = "jpumpkin병원",
            institutionNumber = "01",
            directorName = "jpumpkin"
        )

        hospitalService.createHospital(request)
    }

}