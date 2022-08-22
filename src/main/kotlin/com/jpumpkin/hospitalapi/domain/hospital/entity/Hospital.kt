package com.jpumpkin.hospitalapi.domain.hospital.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Hospital(
    @Column(nullable = false, length = 45)
    val name: String,

    @Column(nullable = false, length = 20)
    val institutionNumber: String,

    @Column(nullable = false, length = 10)
    val directorName: String
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