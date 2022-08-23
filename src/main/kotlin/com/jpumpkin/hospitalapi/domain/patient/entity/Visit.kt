package com.jpumpkin.hospitalapi.domain.patient.entity

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import com.jpumpkin.hospitalapi.domain.patient.entity.Patient
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Visit(
    @Column(nullable = false, length = 10)
    val statusCode: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    val patient: Patient
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Version
    val version: Long = 0

    @CreationTimestamp
    val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null
}