package it.manuel.springcert18mar.service

import it.manuel.springcert18mar.pojo.Address

interface IAddressService {
    fun getAddressList(sort: String, order: String, limit: Int): MutableIterable<Address>
}
