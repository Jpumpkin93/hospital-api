package com.jpumpkin.hospitalapi.domain.hospital.api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jpumpkin.hospitalapi.domain.hospital.application.HospitalService
import com.jpumpkin.hospitalapi.domain.hospital.dto.request.CreateHospitalRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post


@WebMvcTest(HospitalApi::class)
internal class HospitalApiTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var hospitalService: HospitalService

    @Test
    fun `병원 생성을 요청한다`() {
        val request = CreateHospitalRequest(
            name = "jpumpkin병원",
            institutionNumber = "01",
            directorName = "jpumpkin"
        )

        mockMvc.post("/hospitals") {
            this.content = jacksonObjectMapper().writeValueAsString(request)
            this.contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }
}