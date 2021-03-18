package it.manuel.springcert18mar.controller

import it.manuel.springcert18mar.pojo.Address
import it.manuel.springcert18mar.repo.IAddressRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(
        private val addressRepository: IAddressRepository
) {
    @GetMapping(value = ["/address"])
    fun getAddressList(
            @RequestParam(defaultValue = "10") limit: Int,
            @RequestParam(defaultValue = "city") sort: String,
            @RequestParam(defaultValue = "asc") order: String,
    ): List<Address> {
        return addressRepository.retrieveAddresses(limit, sort, order)
    }

    @GetMapping(value = ["/address/count"])
    fun countAddressList(): Int {
        return addressRepository.countAddresses()
    }

    @GetMapping(value = ["/address/{lat}/{lon}"])
    fun getAddress(@PathVariable lat: Double, @PathVariable lon: Double): List<Address> {
        return addressRepository.retrieveAddressByLatLon(lat, lon)
    }

    @PostMapping(value = ["/address"])
    fun createAddress(@RequestBody address: Address): Int {
        return addressRepository.createAddress(address)
    }

    @PutMapping(value = ["/address/{lat}/{lon}"])
    fun updateAddress(@PathVariable("lat") lat: Double, @PathVariable lon: Double, @RequestBody address: Address): Int {
        return addressRepository.updateAddress(address)
    }

    @DeleteMapping(value = ["/address/{lat}/{lon}"])
    fun deleteAddress(@PathVariable("lat") lat: Double, @PathVariable lon: Double): Int {
        return addressRepository.deleteAddress(lat, lon)
    }


//    @RequestMapping(value = ["/info"], method = [RequestMethod.GET])
//    fun info(): Authentication? {
//        return SecurityContextHolder.getContext().authentication;
//    }
}
