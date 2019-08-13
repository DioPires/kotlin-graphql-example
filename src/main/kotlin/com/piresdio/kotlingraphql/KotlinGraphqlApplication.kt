package com.piresdio.kotlingraphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KotlinGraphqlApplication

fun main(args: Array<String>) {
	runApplication<KotlinGraphqlApplication>(*args)
}
