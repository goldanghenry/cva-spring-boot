package knu.cpa.model.dto.userHealth.req

import java.time.LocalDate

data class UserHealthPostReq(
    val createdAt: LocalDate,
    val height: Float,
    val weight: Float,
    val highBloodPressure: Boolean,
    val solo: Boolean,
    val city: Boolean,
    val heartDisease: Boolean,
    val job: String,
    val avg_glucose_level: Float,
    val smoking_status: String
)