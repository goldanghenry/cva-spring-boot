package knu.cpa.model.entity

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
data class UserHealth(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false)
        val userId:Long,

        val createdAt: LocalDateTime = LocalDateTime.now(),

        var height: Float,
        var weight: Float,
        var highBloodPressure: Boolean,
        var solo: Boolean,
        var city: Boolean,
        var heartDisease: Boolean,
        var job: Int,

        @OneToOne(mappedBy = "userHealth", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var stroke: Stroke? = null
)
