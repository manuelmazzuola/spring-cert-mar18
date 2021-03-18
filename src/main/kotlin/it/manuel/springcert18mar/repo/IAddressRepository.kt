package it.manuel.springcert18mar.repo

import it.manuel.springcert18mar.pojo.Address

interface IAddressRepository {
    fun retrieveAddresses(limit: Int, sort: String, order: String): List<Address>
    fun retrieveAddressByLatLon(lat: Double, lon: Double): List<Address>
    fun createAddress(address: Address): Int
    fun updateAddress(address: Address): Int
    fun deleteAddress(lat: Double, lon: Double): Int
    fun countAddresses(): Int
}
