package knu.cpa.model.dto.auth.res

import knu.cpa.model.entity.User
import java.time.LocalDate


data class AuthGetRes(
    val name: String?,
    val profileImg: String?,
    val birthday: LocalDate?,
    val gender: Boolean?
){
    constructor(user: User): this(
        name = user.name, profileImg = user.profileImg, birthday = user.birthday, gender = user.gender
    )
}