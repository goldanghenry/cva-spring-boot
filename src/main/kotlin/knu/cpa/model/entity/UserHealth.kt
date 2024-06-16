package knu.cpa.model.entity

import jakarta.persistence.*
import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import java.time.LocalDate

@Entity
data class UserHealth(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @ManyToOne
    var user: User,

    var createdAt: LocalDate,

    var height: Float,

    var weight: Float,

    var highBloodPressure: Boolean,

    var solo: Boolean,

    var city: Boolean,

    var heartDisease: Boolean,

    var job: String,

    var smoking_status: String,

    var avg_glucose_level: Float
)
{
    constructor(userHealthPostReq: UserHealthPostReq, user: User): this(
        id = null,
        user = user,
        createdAt = userHealthPostReq.createdAt,
        height = userHealthPostReq.height,
        weight = userHealthPostReq.weight,
        highBloodPressure = userHealthPostReq.highBloodPressure,
        solo = userHealthPostReq.solo,
        city = userHealthPostReq.city,
        heartDisease = userHealthPostReq.heartDisease,
        job = userHealthPostReq.job,
        smoking_status =  userHealthPostReq.smoking_status,
        avg_glucose_level = userHealthPostReq.avg_glucose_level
    )
}