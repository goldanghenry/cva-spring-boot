package knu.cpa.application

import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication

interface UserHealthApplication {
    fun post(userHealthPostReq: UserHealthPostReq, authentication: Authentication): ResponseEntity<HttpStatus>
}