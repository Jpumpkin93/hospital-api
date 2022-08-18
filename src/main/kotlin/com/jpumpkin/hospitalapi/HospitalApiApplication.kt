package com.jpumpkin.hospitalapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HospitalApiApplication

fun main(args: Array<String>) {
    runApplication<HospitalApiApplication>(*args)
}
