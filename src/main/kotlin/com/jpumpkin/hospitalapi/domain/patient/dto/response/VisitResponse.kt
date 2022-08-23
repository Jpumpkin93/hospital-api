package com.jpumpkin.hospitalapi.domain.patient.dto.response

import com.jpumpkin.hospitalapi.domain.patient.entity.Visit
import java.time.LocalDateTime

data class VisitResponse (
    val createdAt: LocalDateTime,
    val statusCode: String
) {
    companion object {
        fun from(visit: Visit) = VisitResponse(
            createdAt = visit.createdAt!!,
            statusCode = visit.statusCode
        )
    }
}