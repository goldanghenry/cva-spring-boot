package knu.cpa.model.dto.userHealth.req

data class UserHealthReqDto(
        val id: Long,
        val height: Float,
        val weight: Float,
        val highBloodPressure: Boolean,
        val solo: Boolean,
        val city: Boolean,
        val heartDisease: Boolean,
        val job: Int
)
