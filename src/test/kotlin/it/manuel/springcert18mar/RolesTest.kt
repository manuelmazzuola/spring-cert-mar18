package it.manuel.springcert18mar

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // estende jupiter
class RolesTest {
//    @Autowired
//    lateinit var springCertService: ISpringCertService
//
//    @Test
//    @WithMockUser(username = "pippo", roles = ["ADMIN"])
//    fun mustBePermitWrite() {
//        springCertService.writeEntity()
//    }
//
//    @Test
//    @WithMockUser(username = "pippo", roles = ["USER"])
//    fun mustBePermitRead() {
//        springCertService.readEntity()
//    }
//
//    @Test
//    @WithMockUser(username = "pippo", roles = ["USER"])
//    fun mustBeForbiddenWrite() {
//        springCertService.readEntity()
//    }
//
//    @Test
//    @WithMockUser(username = "manuel", roles = ["USER"])
//    fun mustBeUnique() {
//        val users = mutableListOf(UserInfo("manuel", "manuel"), UserInfo("matteo", "matteo"))
//
//        val filteredUsers = springCertService.getUserInfo(users)
//
//        Assertions.assertEquals(filteredUsers.size, 1)
//    }
}
