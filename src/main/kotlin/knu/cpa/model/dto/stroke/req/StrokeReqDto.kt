package knu.cpa.model.dto.stroke.req

data class StrokeReqDto(
        val id: Long,
        val isStroke: Boolean,
        val probability: Float
)