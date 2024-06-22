package knu.cpa.repository

import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

interface UserHealthRepository: JpaRepository<UserHealth, Int> {
    fun findByUser(user: User, pageable: Pageable): List<UserHealth>
    fun findByUserOrderByIdDesc(user: User, pageable: Pageable): List<UserHealth>
    fun findTopByUserOrderByIdDesc(user: User): UserHealth
    @Transactional
    fun deleteByIdAndUser(id: Int, user: User): Int
}