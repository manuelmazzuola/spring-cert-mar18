package it.manuel.springcert18mar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.web.client.RestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {
    @LocalServerPort
    lateinit var port: Number

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Test
    fun mustBeCallOk() {
        val address = restTemplate
                .getForEntity("http://localhost:$port/api/address", List::class.java)
                .body

        Assertions.assertTrue(address != null)
        Assertions.assertTrue(address.isNotEmpty())
    }
}
