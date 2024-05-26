package knu.cpa.model.dto.auth.res

data class AuthLoginRes(
    val accessToken: String,
    val refreshToken: String
)
