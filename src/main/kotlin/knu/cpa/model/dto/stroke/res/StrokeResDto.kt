package knu.cpa.model.dto.stroke.res

import knu.cpa.model.entity.Stroke

data class StrokeResDto(
        val id: Long,
        var isStroke: Boolean?,
        var probability: Float?,
) {
    constructor(stroke: Stroke) : this(
            id = stroke.id,
            isStroke = stroke.isStroke,
            probability = stroke.probability,
    )
}