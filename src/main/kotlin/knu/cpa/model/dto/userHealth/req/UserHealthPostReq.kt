package knu.cpa.model.dto.userHealth.req

import knu.cpa.model.state.JobState
import java.time.LocalDate

data class UserHealthPostReq(
    val createdAt: LocalDate,
    val height: Float,
    val weight: Float,
    val highBloodPressure: Boolean,
    val solo: Boolean,
    val city: Boolean,
    val heartDisease: Boolean,
    val job: JobState
)