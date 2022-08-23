package com.jpumpkin.hospitalapi.domain.patient.entity

import com.jpumpkin.hospitalapi.domain.hospital.entity.Hospital
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Patient(
    @Column(nullable = false, length = 45)
    var name: String,

    @Column(nullable = false, length = 13)
    val registerNumber: String,

    @Column(nullable = false, length = 10)
    var genderCode: String,

    @Column(length = 10)
    var dateOfBirth: String,

    @Column(length = 20)
    var mobileNumber: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    val hospital: Hospital,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "patient")
    val visitList: MutableList<Visit> = mutableListOf()
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

    fun update(patient: Patient) {
        this.name = patient.name
        this.genderCode = patient.genderCode
        this.dateOfBirth = patient.dateOfBirth
        this.mobileNumber = patient.mobileNumber
    }

    fun visit(statusCode: String) {
        this.visitList.add(
            Visit(
                statusCode = statusCode,
                hospital = this.hospital,
                patient = this
            )
        )
    }
}