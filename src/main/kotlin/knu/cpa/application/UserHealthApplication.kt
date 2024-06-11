package knu.cpa.application

import knu.cpa.model.dto.userHealth.res.UserHealthReqDto
import knu.cpa.model.dto.userHealth.res.UserHealthResDto
import knu.cpa.model.dto.userHealth.res.UserHealthResElementDto
import org.springframework.security.core.Authentication
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

interface UserHealthApplication {
    fun getUserHealthList(authentication: Authentication): ResponseEntity<List<UserHealthResElementDto>>
    fun getUserHealth(userHealthId: Long, authentication: Authentication): ResponseEntity<UserHealthResDto>
    fun postUserHealth(userHealthReqDto: UserHealthReqDto, authentication: Authentication): ResponseEntity<HttpStatus>
    fun patchUserHealth(userHealthReqDto: UserHealthReqDto, authentication: Authentication): ResponseEntity<HttpStatus>
    fun deleteUserHealth(userHealthId: Long, authentication: Authentication): ResponseEntity<HttpStatus>
}