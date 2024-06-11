package knu.cpa.application.impl

import knu.cpa.application.UserHealthApplication
import knu.cpa.model.dto.userHealth.res.UserHealthReqDto
import knu.cpa.model.dto.userHealth.res.UserHealthResDto
import knu.cpa.model.dto.userHealth.res.UserHealthResElementDto
import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import knu.cpa.repository.UserHealthRepository
import knu.cpa.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.http.*
import org.springframework.security.core.Authentication

@Service
class UserHealthApplicationImpl(
        private val userRepository: UserRepository,
        private val userHealthRepository: UserHealthRepository
) : UserHealthApplication {

    override fun getUserHealthList(authentication: Authentication): ResponseEntity<List<UserHealthResElementDto>> {
        val userId = User(authentication).id
        val userHealthList = userHealthRepository.findAllByUserId(userId)

        val responseList = userHealthList.map { UserHealthResElementDto(it) }
        return ResponseEntity.ok(responseList)
    }

    override fun getUserHealth(userHealthId: Long, authentication: Authentication): ResponseEntity<UserHealthResDto> {
        val userId = User(authentication).id
        val userHealth = userHealthRepository.findByIdAndUserId(userHealthId, userId)
                .orElseThrow { Exception("User health info not found") }
        return ResponseEntity.ok(UserHealthResDto(userHealth))
    }

    override fun postUserHealth(userHealthReqDto: UserHealthReqDto, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userId = User(authentication).id
        val userHealth = UserHealth(
                id = 0,
                userId=userId,
                height = userHealthReqDto.height,
                weight = userHealthReqDto.weight,
                highBloodPressure = userHealthReqDto.highBloodPressure,
                solo = userHealthReqDto.solo,
                city = userHealthReqDto.city,
                heartDisease = userHealthReqDto.heartDisease,
                job = userHealthReqDto.job,
        )
        userHealthRepository.save(userHealth)
        return ResponseEntity(HttpStatus.CREATED)
    }

    override fun patchUserHealth(userHealthReqDto: UserHealthReqDto, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userId = User(authentication).id
        val userHealth = userHealthRepository.findByIdAndUserId(userHealthReqDto.id, userId)
                .orElseThrow { Exception("User health info not found") }

        userHealth.height = userHealthReqDto.height
        userHealth.weight = userHealthReqDto.weight
        userHealth.highBloodPressure = userHealthReqDto.highBloodPressure
        userHealth.solo = userHealthReqDto.solo
        userHealth.city = userHealthReqDto.city
        userHealth.heartDisease = userHealthReqDto.heartDisease
        userHealth.job = userHealthReqDto.job

        userHealthRepository.save(userHealth)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteUserHealth(userHealthId: Long, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userId = User(authentication).id
        val userHealth = userHealthRepository.findByIdAndUserId(userHealthId, userId)
                .orElseThrow { Exception("User health info not found") }

        userHealthRepository.delete(userHealth)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}