package com.jpumpkin.hospitalapi.global.extension

import com.jpumpkin.hospitalapi.global.error.ApiException
import com.jpumpkin.hospitalapi.global.error.ErrorCode
import org.springframework.data.repository.CrudRepository

fun <T> CrudRepository<T, Long>.findByIdOrThrow(id: Long): T {
    return findById(id).orElseThrow { ApiException(ErrorCode.NOT_FOUND) }
}