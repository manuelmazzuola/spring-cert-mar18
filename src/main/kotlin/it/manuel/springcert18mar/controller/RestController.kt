package it.manuel.springcert18mar.controller

import it.manuel.springcert18mar.pojo.Address
import it.manuel.springcert18mar.pojo.AddressPk
import it.manuel.springcert18mar.pojo.AuditLog
import it.manuel.springcert18mar.repo.AuditRepository
import it.manuel.springcert18mar.repo.IAddressJpaRepository
import it.manuel.springcert18mar.service.IAddressService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RestController(
        @Qualifier("ciao") private val addressRepository: IAddressJpaRepository,
        private val addressService: IAddressService,
        private val auditRepository: AuditRepository
) {
    @GetMapping(value = ["/address"])
    fun getAddressList(
            @RequestParam(defaultValue = "10") limit: Int,
            @RequestParam(defaultValue = "city") sort: String,
            @RequestParam(defaultValue = "asc") order: String,
    ): MutableIterable<Address> {
        return addressService.getAddressList(sort, order, limit)
    }

    @GetMapping(value = ["/address/count"])
    fun countAddressList(): Long {
        return addressRepository.count()
    }

    @GetMapping(value = ["/address/{lat}/{lon}"])
    fun getAddress(@PathVariable lat: Double, @PathVariable lon: Double): Optional<Address> {
        return addressRepository.findById(AddressPk(lat, lon))
    }

    @PostMapping(value = ["/address"])
    fun createAddress(@RequestBody address: Address): Address {
        return addressRepository.save(address)
    }

    @PutMapping(value = ["/address/{lat}/{lon}"])
    fun updateAddress(@PathVariable("lat") lat: Double, @PathVariable lon: Double, @RequestBody address: Address): Address {
        return addressRepository.save(address)
    }

    @DeleteMapping(value = ["/address/{lat}/{lon}"])
    fun deleteAddress(@PathVariable("lat") lat: Double, @PathVariable lon: Double) {
        return addressRepository.deleteById(AddressPk(lat, lon))
    }

    @GetMapping(value = ["/audit"])
    fun getAuditLog(): MutableList<AuditLog> {
        return auditRepository.findAll()
    }


//    @RequestMapping(value = ["/info"], method = [RequestMethod.GET])
//    fun info(): Authentication? {
//        return SecurityContextHolder.getContext().authentication;
//    }
}
