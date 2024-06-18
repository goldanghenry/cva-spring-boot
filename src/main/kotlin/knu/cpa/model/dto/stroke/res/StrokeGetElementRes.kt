package knu.cpa.model.dto.stroke.res

import knu.cpa.model.entity.Stroke

data class StrokeGetElementRes(
    val id: Int?,
    var userHealthId: Int?,

    var probability: Float,

    var isHighWeight: Boolean,
    var isLowWeight: Boolean,

    var isAge: Boolean,

    var isBloodPressure: Boolean,

    var isHeartDisease: Boolean
)
{
    constructor(stroke: Stroke): this(
        id = stroke.id,
        userHealthId = stroke.userHealth.id,
        probability = stroke.probability,
        isHighWeight = stroke.isHighWeight,
        isLowWeight = stroke.isLowWeight,
        isAge = stroke.isAge,
        isBloodPressure = stroke.isBloodPressure,
        isHeartDisease = stroke.isHeartDisease
    )
}