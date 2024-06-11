package knu.cpa.model.dto.userHealth.res

import knu.cpa.model.entity.UserHealth
import java.time.LocalDateTime

data class UserHealthResDto(
        val id: Long,
        val userId: Long,
        val createdAt: LocalDateTime,
        val height: Float,
        val weight: Float,
        val highBloodPressure: Boolean,
        val solo: Boolean,
        val city: Boolean,
        val heartDisease: Boolean,
        val job: Int
) {
    constructor(userHealth: UserHealth) : this(
            id = userHealth.id,
            userId = userHealth.userId,
            createdAt = userHealth.createdAt,
            height = userHealth.height,
            weight = userHealth.weight,
            highBloodPressure = userHealth.highBloodPressure,
            solo = userHealth.solo,
            city = userHealth.city,
            heartDisease = userHealth.heartDisease,
            job = userHealth.job
    )
}
