package it.manuel.springcert18mar.repo

import it.manuel.springcert18mar.pojo.AuditLog
import org.springframework.data.mongodb.repository.MongoRepository

interface AuditRepository : MongoRepository<AuditLog, String>
