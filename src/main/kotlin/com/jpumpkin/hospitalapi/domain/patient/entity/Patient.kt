package com.jpumpkin.hospitalapi.domain.patient.entity

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import com.jpumpkin.hospitalapi.domain.visit.entity.Visit
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Patient(
    @Column(nullable = false, length = 45)
    val name: String,

    @Column(nullable = false, length = 13)
    val registerNumber: String,

    @Column(nullable = false, length = 10)
    val genderCode: String,

    @Column(length = 10)
    val dateOfBirth: String,

    @Column(length = 20)
    val mobileNumber: String? = null,

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "patient")
    val visitList: List<Visit> = listOf()
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