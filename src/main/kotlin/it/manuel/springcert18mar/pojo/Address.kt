package it.manuel.springcert18mar.pojo

import javax.persistence.*

@Entity(name = "Address")
@IdClass(AddressPk::class)
data class Address(
        @Id val lat: Double,
        @Id val lon: Double,
        val address: String,
        val city: String,
        val region: String,
        val state: String,
        @Column(nullable = true) val current_meteo: String,
        @Transient val rainingDay: Boolean
)
