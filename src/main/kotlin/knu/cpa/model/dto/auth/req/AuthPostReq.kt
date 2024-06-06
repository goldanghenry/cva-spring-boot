package knu.cpa.model.dto.auth.req

import java.time.LocalDate

data class AuthPostReq(
    val name: String,
    val birthday: LocalDate,
    val gender: Boolean
)
