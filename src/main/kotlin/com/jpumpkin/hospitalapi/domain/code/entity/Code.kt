package com.jpumpkin.hospitalapi.domain.code.entity

import javax.persistence.*


@Entity
class Code(
    @Id
    val code: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_group_id")
    val codeGroup: CodeGroup
) {
}