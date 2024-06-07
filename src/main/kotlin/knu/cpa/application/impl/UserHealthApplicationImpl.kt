package knu.cpa.application.impl

import knu.cpa.application.UserHealthApplication
import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import knu.cpa.repository.UserHealthRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class UserHealthApplicationImpl(private val userHealthRepository: UserHealthRepository) : UserHealthApplication{
    override fun post(userHealthPostReq: UserHealthPostReq, authentication: Authentication): ResponseEntity<HttpStatus> {
        userHealthRepository.save(UserHealth(userHealthPostReq, User(authentication)))
        return ResponseEntity.ok().build()
    }
}