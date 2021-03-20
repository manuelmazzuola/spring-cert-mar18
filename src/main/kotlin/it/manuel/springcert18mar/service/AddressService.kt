package it.manuel.springcert18mar.service

import it.manuel.springcert18mar.pojo.Address
import it.manuel.springcert18mar.repo.IAddressJpaRepository
import org.springframework.data.domain.Sort
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Service

@Service
open class AddressService(
        private val addressRepository: IAddressJpaRepository
) : IAddressService {
    @Secured(value = ["ROLE_ADMIN"])
    override fun getAddressList(sort: String, order: String, limit: Int): MutableIterable<Address> {
        return addressRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort))
    }
}
