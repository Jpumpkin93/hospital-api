package com.jpumpkin.hospitalapi.domain.patient.repository

import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import com.jpumpkin.hospitalapi.domain.patient.entity.QPatient.patient
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository


@Repository
class PatientQueryRepository(
    val jpaQueryFactory: JPAQueryFactory
) {

    fun findAll(name: String?, registerNumber: String?, dateOfBirth: String?, pageable: Pageable): PageImpl<Patient> {
        val result = jpaQueryFactory
            .selectFrom(patient)
            .where(
                eqName(name),
                eqRegisterNumber(registerNumber),
                eqDateOfBirth(dateOfBirth)
            )
            .leftJoin(patient.visitList)
            .fetchJoin()
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val totalCount = jpaQueryFactory
            .select(patient.count())
            .from(patient)
            .fetchOne() ?: 0

        return PageImpl(result, pageable, totalCount)

    }

    private fun eqName(name: String?) = name?.let { patient.name.eq(name) }
    private fun eqRegisterNumber(registerNumber: String?) = registerNumber?.let { patient.registerNumber.eq(registerNumber) }
    private fun eqDateOfBirth(dateOfBirth: String?) = dateOfBirth?.let { patient.dateOfBirth.eq(dateOfBirth) }
}
