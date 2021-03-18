package it.manuel.springcert18mar.controller

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {
    @RequestMapping(value = ["/info"], method = [RequestMethod.GET])
    fun info(): Authentication? {
        return SecurityContextHolder.getContext().authentication;
    }
}
