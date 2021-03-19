package it.manuel.springcert18mar.repo

import it.manuel.springcert18mar.pojo.Address
import it.manuel.springcert18mar.pojo.AddressPk
import org.springframework.data.repository.CrudRepository

interface IAddressJpaRepository : CrudRepository<Address, AddressPk> {
}
