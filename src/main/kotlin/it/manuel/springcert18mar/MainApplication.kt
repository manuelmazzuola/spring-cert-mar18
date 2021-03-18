package it.manuel.springcert18mar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
open class MainApplication

fun main(args: Array<String>) {
    // org.springframework.boot.SpringApplication.run()
    runApplication<MainApplication>(*args) // profilo default
}
