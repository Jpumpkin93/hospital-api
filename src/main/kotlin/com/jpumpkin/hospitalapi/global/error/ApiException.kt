package com.jpumpkin.hospitalapi.global.error

class ApiException(
    val code: Int,
    override val message: String
): RuntimeException() {

    constructor(errorCode: ErrorCode): this(errorCode.code, errorCode.message)
}