package it.manuel.springcert18mar.controller

import it.manuel.springcert18mar.service.IAddressService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(
        private val addressService: IAddressService
) {
    @GetMapping(value = ["/summary"])
    fun getSummary(model: Model, ): String {
        model.apply {
            addAttribute("address", addressService.getAddressList("city", "asc", 10))
        }

        return "address"
    }
}
