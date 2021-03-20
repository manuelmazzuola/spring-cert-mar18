package it.manuel.springcert18mar.repo

import it.manuel.springcert18mar.pojo.Address
import it.manuel.springcert18mar.pojo.AddressPk
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.PagingAndSortingRepository

@Qualifier("ciao")
interface IAddressJpaRepository : PagingAndSortingRepository<Address, AddressPk> {
}
