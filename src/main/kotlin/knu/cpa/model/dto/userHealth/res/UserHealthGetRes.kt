package knu.cpa.model.dto.userHealth.res

import knu.cpa.model.entity.UserHealth
import knu.cpa.model.state.JobState
import java.time.LocalDate

data class UserHealthGetRes(
    val id: Int?,
    val createdAt: LocalDate,
    val height: Float,
    val weight: Float,
    val highBloodPressure: Boolean,
    val solo: Boolean,
    val city: Boolean,
    val heartDisease: Boolean,
    val job: JobState
){
    constructor(userHealth: UserHealth): this(
        id = userHealth.id,
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
