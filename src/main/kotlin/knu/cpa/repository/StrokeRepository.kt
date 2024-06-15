package knu.cpa.repository

import knu.cpa.model.entity.Stroke
import knu.cpa.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface StrokeRepository: JpaRepository<Stroke, Int> {

    @Query(
        "SELECT s FROM Stroke s " +
        "LEFT JOIN s.userHealth uH " +
        "LEFT JOIN uH.user u " +
        "WHERE u = :user"
    )
    fun findByUser(user: User): List<Stroke>
}