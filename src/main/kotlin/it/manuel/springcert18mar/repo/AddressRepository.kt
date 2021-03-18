package it.manuel.springcert18mar.repo

import it.manuel.springcert18mar.mapper.AddressRowMapper
import it.manuel.springcert18mar.pojo.Address
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class AddressRepository(
        private val jdbcTemplate: JdbcTemplate
) : IAddressRepository {
    override fun retrieveAddresses(limit: Int, sort: String, order: String): List<Address> {
        return jdbcTemplate.query("select * from Address ORDER BY $sort $order LIMIT $limit", AddressRowMapper())
    }

    override fun retrieveAddressByLatLon(lat: Double, lon: Double): List<Address> {
        return jdbcTemplate.query("select * from Address where lat=$lat and lon=$lon", AddressRowMapper())
    }

    override fun createAddress(address: Address): Int {
        return jdbcTemplate.update(
                "insert into Address(lat, lon, address, city, region, state, current_meteo) values(?, ?, ?, ?, ?, ?, ?)",
                address.lat,
                address.lon,
                address.address,
                address.city,
                address.region,
                address.state,
                address.current_meteo
        )
    }

    override fun updateAddress(address: Address): Int {
        return jdbcTemplate.update(
                "update Address set address=?, city=?, region=?, state=?, current_meteo=? where lat=? and lon=?",
                address.address,
                address.city,
                address.region,
                address.state,
                address.current_meteo,
                address.lat,
                address.lon
        )
    }

    override fun deleteAddress(lat: Double, lon: Double): Int {
        return jdbcTemplate.update("delete from Address where lat = ? and lon = ?", lat, lon)
    }

    override fun countAddresses(): Int {
        return jdbcTemplate.queryForObject("select COUNT(*) from Address", Int::class.java)
    }
}
