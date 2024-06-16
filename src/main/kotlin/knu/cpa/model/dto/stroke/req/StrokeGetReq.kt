package knu.cpa.model.dto.stroke.req

import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import knu.cpa.model.entity.User
import java.time.LocalDate
import java.time.Period

data class StrokeGetReq(
    val id: Int,
    val gender: String?,
    val age: Int,
    val hypertension: Short,
    val heart_disease: Short,
    val ever_married: String,
    val work_type: String,
    val residence_type: String,
    val avg_glucose_level: Float,
    val bmi: Float,
    val smoking_status: String
)
{
    constructor(user: User, userHealthPostReq: UserHealthPostReq): this(
        id = 1,
        gender = if(user.gender == true) "Male" else "Female",
        age = Period.between(user.birthday, LocalDate.now()).years,
        hypertension = if(userHealthPostReq.highBloodPressure) 1 else 0,
        heart_disease = if(userHealthPostReq.heartDisease) 1 else 0,
        ever_married = if(!userHealthPostReq.solo) "Yes" else "No",
        work_type = userHealthPostReq.job,
        residence_type = if(userHealthPostReq.city) "Urban" else "Rural",
        avg_glucose_level = userHealthPostReq.avg_glucose_level,
        bmi = (userHealthPostReq.weight)/((userHealthPostReq.height * userHealthPostReq.height) / 10000),
        smoking_status = userHealthPostReq.smoking_status
    )
}