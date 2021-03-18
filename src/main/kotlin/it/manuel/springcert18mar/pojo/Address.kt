package it.manuel.springcert18mar.pojo

data class Address(
        val lat: Double,
        val lon: Double,
        val address: String,
        val city: String,
        val region: String,
        val state: String,
        val current_meteo: String,
)
