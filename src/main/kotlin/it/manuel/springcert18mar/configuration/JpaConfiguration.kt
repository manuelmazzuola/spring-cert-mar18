package it.manuel.springcert18mar.configuration

import org.hibernate.SessionFactory
import org.hibernate.dialect.MySQL8Dialect
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.*
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder
import org.springframework.web.client.RestTemplate
import java.util.*
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(
        basePackages = ["it.manuel.springcert18mar.repo"],
)
open class JpaConfiguration {
    @Bean
    open fun entityManagerFactory(dataSource: DataSource): SessionFactory {
        return LocalSessionFactoryBuilder(dataSource)
                .scanPackages("it.manuel.springcert18mar.pojo")
                .addProperties(hibernateProperties())
                .buildSessionFactory()
    }

    @Bean
    open fun hibernateProperties(): Properties {
        val hibernateProp = Properties()
        hibernateProp["hibernate.dialect"] = MySQL8Dialect::class.java.name
        hibernateProp["hibernate.format_sql"] = true
        hibernateProp["hibernate.use_sql_comments"] = true
        hibernateProp["hibernate.show_sql"] = false
        return hibernateProp
    }

    @Bean
    @Scope(value = "prototype")
    open fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().build()
    }

    @Bean
    @Profile(value = ["dev"])
    open fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.h2.Driver")
        dataSource.url = "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"
        dataSource.username = "sa"
        dataSource.password = "sa"
        return dataSource
    }
}
