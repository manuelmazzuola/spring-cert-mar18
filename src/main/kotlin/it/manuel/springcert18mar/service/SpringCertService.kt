package it.manuel.springcert18mar.service

import it.manuel.springcert18mar.pojo.UserInfo
import org.springframework.stereotype.Service
import javax.annotation.security.RolesAllowed

@Service
open class SpringCertService
//    @Secured(value = ["ROLE_ADMIN"])
//    override fun writeEntity() {
//    }
//
//    @RolesAllowed(value = ["ROLE_USER"])
//    override fun readEntity() {
//    }
//
//    @PostFilter("filterObject.username == authentication.name")
//    override fun getUserInfo(allUserInfo: MutableList<UserInfo>): List<UserInfo> {
//        return allUserInfo
//    }

