package it.manuel.springcert18mar.configuration

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.client.RestTemplate
import javax.sql.DataSource

@Configuration
@EnableJdbcRepositories
open class DataConfiguration {
    @Bean
    @Scope(scopeName = "singleton")
    open fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @Scope(value = "prototype")
    open fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().build()
    }
}
