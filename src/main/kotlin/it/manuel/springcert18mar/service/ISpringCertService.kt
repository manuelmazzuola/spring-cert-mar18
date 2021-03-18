package it.manuel.springcert18mar.service

import it.manuel.springcert18mar.pojo.UserInfo

interface ISpringCertService {
    fun writeEntity()
    fun readEntity()
    fun getUserInfo(allUserInfo: MutableList<UserInfo>): List<UserInfo>
}
