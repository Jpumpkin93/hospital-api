package com.jpumpkin.hospitalapi.global.error

enum class ErrorCode(
    val code: Int,
    val message: String
) {

    NOT_FOUND(8000, "not found"),
    INTERNAL_SERVER_ERROR(9999, "internal server error")
}