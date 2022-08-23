package com.jpumpkin.hospitalapi.domain.patient.repository

import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import com.jpumpkin.hospitalapi.domain.patient.entity.QPatient.patient
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository


@Repository
class PatientQueryRepository(
    val jpaQueryFactory: JPAQueryFactory
) {

    fun findAll(): MutableList<Patient> =
        jpaQueryFactory
            .selectFrom(patient)
            .leftJoin(patient.visitList)
            .fetchJoin()
            .fetch()

}