package it.manuel.springcert18mar

import it.manuel.springcert18mar.pojo.AuditLog
import it.manuel.springcert18mar.repo.AuditRepository
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
@Aspect
open class AuditAspect(
        val auditRepository: AuditRepository
) {
    @Pointcut("execution(* it.manuel.springcert18mar.service.AddressService.*(..))")
    fun execPointcut() {
    }

    @Around("execPointcut()")
    fun aroundExecPointcut(joinPoint: ProceedingJoinPoint): Any? {
        val user = SecurityContextHolder.getContext().authentication
        val log = AuditLog(
                null,
                (user.principal as UserDetails).username,
                joinPoint.signature.name,
                user.authorities.joinToString(),
                Date().time
        )

        try {
            val ret = joinPoint.proceed()
            auditRepository.save(log)
            return ret
        } catch (ex: Throwable) {
            throw ex
        }
    }
}
