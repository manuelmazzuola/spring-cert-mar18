package it.manuel.springcert18mar.configuration

import org.hibernate.SessionFactory
import org.hibernate.dialect.MySQL8Dialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder
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
}
