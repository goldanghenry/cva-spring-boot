package knu.cpa.repository

import knu.cpa.model.entity.Stroke
import knu.cpa.model.entity.UserHealth
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StrokeRepository : JpaRepository<Stroke, Long> {
    fun findAllByUserId(userId: Long): List<Stroke>
    fun findByIdAndUserId(id: Long, userId: Long): Optional<Stroke>
}