package com.jpumpkin.hospitalapi.domain.patient.api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jpumpkin.hospitalapi.domain.patient.application.PatientService
import com.jpumpkin.hospitalapi.domain.patient.dto.request.CreatePatientRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.request.PatientVisitRequest
import com.jpumpkin.hospitalapi.domain.patient.dto.request.UpdatePatientRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*


@WebMvcTest(PatientApi::class)
internal class PatientApiTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var patientService: PatientService

    @Test
    fun `환자 생성을 요청한다`() {
        val request = CreatePatientRequest(
            name = "jpumpkin",
            genderCode = "M",
            dateOfBirth = "20220101",
            mobileNumber = "010-0000-0000",
            hospitalId = 1L
        )

        mockMvc.post("/patients") {
            this.content = jacksonObjectMapper().writeValueAsString(request)
            this.contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }

    @Test
    fun `환자 정보 수정을 요청한다`() {
        val request = UpdatePatientRequest(
            name = "jpumpkin",
            genderCode = "M",
            dateOfBirth = "20220101",
            mobileNumber = "010-0000-0000"
        )
        val patientId = 1L

        mockMvc.put("/patients/${patientId}") {
            this.content = jacksonObjectMapper().writeValueAsString(request)
            this.contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }

    @Test
    fun `환자 삭제를 요청한다`() {
        val patientId = 1L

        mockMvc.delete("/patients/${patientId}")
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    fun `환자 한명의 정보를 요청한다`() {
        val patientId = 1L

        mockMvc.get("/patients/${patientId}")
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    fun `환자 목록을 요청한다`() {
        mockMvc.get("/patients")
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    fun `환자 방문 생성을 요청한다`() {
        val request = PatientVisitRequest(statusCode = "방문중")

        val patientId = 1L

        mockMvc.post("/patients/${patientId}/visit") {
            this.content = jacksonObjectMapper().writeValueAsString(request)
            this.contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }


}