package com.jpumpkin.hospitalapi.domain.code.entity

import javax.persistence.*


@Entity
class CodeGroup(
    @Id
    val codeGroup: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @Column(nullable = false, length = 10)
    val description: String,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "codeGroup")
    val codeList: List<Code> = listOf()
) {
}