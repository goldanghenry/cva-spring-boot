package knu.cpa.repository

import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserHealthRepository : JpaRepository<UserHealth, Long> {
    fun findAllByUserId(userId: Long): List<UserHealth>
    fun findByIdAndUserId(id: Long, userId: Long): Optional<UserHealth>
}