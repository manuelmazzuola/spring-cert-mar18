package it.manuel.springcert18mar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import org.springframework.web.client.RestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
class AddressControllerH2Test {
    @LocalServerPort
    lateinit var port: Number

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Test
    @Sql(value = ["classpath:address.sql", "classpath:address-populate.sql"])
    @WithMockUser(username = "admin", password = "admin", roles = ["ADMIN"])
    fun mustBeCallOk() {
        val address = restTemplate
                .getForEntity("http://localhost:$port/api/address", List::class.java)
                .body

        Assertions.assertTrue(address != null)
        Assertions.assertTrue(address.isNotEmpty())
    }
}
