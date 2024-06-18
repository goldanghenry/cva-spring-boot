package knu.cpa.model.dto.healthInfo.res

import knu.cpa.model.entity.HealthInfo

data class HealthInfoGetElementRes(
    val id: Int,
    val title: String,
    val photo: String,
    val url: String
){
    constructor(healthInfo: HealthInfo): this(
        id = healthInfo.id,
        title = healthInfo.title,
        photo = healthInfo.photo,
        url = healthInfo.url
    )
}
