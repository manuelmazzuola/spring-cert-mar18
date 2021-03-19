package it.manuel.springcert18mar.controller

import it.manuel.springcert18mar.pojo.Address
import it.manuel.springcert18mar.pojo.AddressPk
import it.manuel.springcert18mar.repo.IAddressJpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RestController(
        private val addressRepository: IAddressJpaRepository
) {
    @GetMapping(value = ["/address"])
    fun getAddressList(
            @RequestParam(defaultValue = "10") limit: Int,
            @RequestParam(defaultValue = "city") sort: String,
            @RequestParam(defaultValue = "asc") order: String,
    ): MutableIterable<Address> {
        return addressRepository.findAll()
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
    fun updateAddress(@PathVariable("lat") lat: Double, @PathVariable lon: Double, @RequestBody address: Address): Address? {
        return addressRepository.save(address)
    }

    @DeleteMapping(value = ["/address/{lat}/{lon}"])
    fun deleteAddress(@PathVariable("lat") lat: Double, @PathVariable lon: Double) {
        return addressRepository.deleteById(AddressPk(lat, lon))
    }


//    @RequestMapping(value = ["/info"], method = [RequestMethod.GET])
//    fun info(): Authentication? {
//        return SecurityContextHolder.getContext().authentication;
//    }
}
