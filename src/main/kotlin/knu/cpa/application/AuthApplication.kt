package knu.cpa.application

import knu.cpa.model.dto.auth.req.AuthPostReq
import knu.cpa.model.dto.auth.res.AuthGetRes
import knu.cpa.model.dto.auth.res.AuthLoginRes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication

interface AuthApplication {
    fun getLogin(code: String): ResponseEntity<AuthLoginRes>
    fun patchLogin(refreshToken: String): ResponseEntity<AuthLoginRes>
    fun postInfo(authPostReq: AuthPostReq, authentication: Authentication): ResponseEntity<HttpStatus>
    fun getInfo(authentication: Authentication): ResponseEntity<AuthGetRes>
}