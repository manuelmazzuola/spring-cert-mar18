package it.manuel.springcert18mar.pojo

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "logging")
data class AuditLog(
        @MongoId val id: String?,
        val user: String?,
        val joinPoint: String?,
        val role: String?,
        val ts: Long?,
)
