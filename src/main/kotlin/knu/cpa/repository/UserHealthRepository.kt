package knu.cpa.repository

import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface UserHealthRepository: JpaRepository<UserHealth, Int> {
    fun findByUser(user: User, pageable: Pageable): List<UserHealth>
}