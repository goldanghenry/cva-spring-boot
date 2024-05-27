package knu.cpa.application

import knu.cpa.model.dto.auth.res.AuthLoginRes
import org.springframework.http.ResponseEntity

interface AuthApplication {
    fun getLogin(code: String): ResponseEntity<AuthLoginRes>
    fun patchLogin(refreshToken: String): ResponseEntity<AuthLoginRes>
}