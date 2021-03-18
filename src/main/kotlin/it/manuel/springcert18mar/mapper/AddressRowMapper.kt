package it.manuel.springcert18mar.mapper

import it.manuel.springcert18mar.pojo.Address
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class AddressRowMapper : RowMapper<Address> {
    override fun mapRow(res: ResultSet, id: Int): Address {
        return Address(
                res.getDouble("lat"),
                res.getDouble("lon"),
                res.getString("address"),
                res.getString("city"),
                res.getString("region"),
                res.getString("state"),
                res.getString("current_meteo"),
        )
    }
}
