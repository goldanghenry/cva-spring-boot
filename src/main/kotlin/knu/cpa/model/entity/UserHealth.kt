package knu.cpa.model.entity

import jakarta.persistence.*
import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import knu.cpa.model.state.JobState
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

    @Enumerated(EnumType.STRING)
    var job: JobState
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
        job = userHealthPostReq.job
    )
}