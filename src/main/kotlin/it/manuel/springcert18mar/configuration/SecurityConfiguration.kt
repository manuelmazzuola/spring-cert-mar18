package it.manuel.springcert18mar.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        proxyTargetClass = true
)
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/info").permitAll()
                .mvcMatchers("/api/summary").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().permitAll().and()
                .httpBasic().and()
                .logout().permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("user")
                .password(passwordEncoder().encode("12345"))
                .roles("USER")
                .and()
                .withUser("manuel")
                .password(passwordEncoder().encode("manuel")).roles("ADMIN", "USER")
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder = NoOpPasswordEncoder.getInstance()
}
