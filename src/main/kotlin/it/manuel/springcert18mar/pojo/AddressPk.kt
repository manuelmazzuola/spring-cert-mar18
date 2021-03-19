package it.manuel.springcert18mar.pojo

import java.io.Serializable

class AddressPk : Serializable {
    private var lat: Double? = null
    private var lon: Double? = null

    constructor()

    constructor(lat: Double, lon: Double) {
        this.lat = lat
        this.lon = lon
    }
}
