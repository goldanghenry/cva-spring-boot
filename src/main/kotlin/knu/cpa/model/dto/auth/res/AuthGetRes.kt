package knu.cpa.model.dto.auth.res

import knu.cpa.model.entity.User


data class AuthGetRes(
    val name: String?,
    val img: String?
){
    constructor(user: User): this(
        name = user.name, img = user.profileImg
    )
}