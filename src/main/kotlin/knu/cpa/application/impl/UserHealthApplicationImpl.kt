package knu.cpa.application.impl

import knu.cpa.application.UserHealthApplication
import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import knu.cpa.model.dto.userHealth.res.UserHealthGetElementRes
import knu.cpa.model.dto.userHealth.res.UserHealthGetRes
import knu.cpa.model.entity.Stroke
import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import knu.cpa.repository.StrokeRepository
import knu.cpa.repository.UserHealthRepository
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class UserHealthApplicationImpl(
    private val userHealthRepository: UserHealthRepository,
    private val strokeRepository: StrokeRepository) : UserHealthApplication{
    override fun post(userHealthPostReq: UserHealthPostReq, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userHealth = userHealthRepository.save(UserHealth(userHealthPostReq, User(authentication)))
        CompletableFuture.runAsync {
            strokeRepository.save(
                Stroke(id = null, userHealth = userHealth, probability = 0.5F, isWeight = false, isAge = false, isBloodPressure = false, isHeartDisease = false)
            )
        }
        return ResponseEntity.ok().build()
    }

    override fun getList(pageNumber: Int, pageSize: Int, authentication: Authentication): ResponseEntity<List<UserHealthGetElementRes>> {
        return ResponseEntity.ok(userHealthRepository.findByUser(User(authentication), PageRequest.of(pageNumber, pageSize)).map{
                userHealth -> UserHealthGetElementRes(userHealth)
        })
    }

    override fun get(id: Int?, authentication: Authentication): ResponseEntity<UserHealthGetRes> {
        return ResponseEntity.ok(
            UserHealthGetRes(if(id == null)
                userHealthRepository.findTopByUserOrderByIdDesc(User(authentication))
            else
                userHealthRepository.findById(id).orElseThrow { NullPointerException() } ?: throw NullPointerException())
        )

    }

    override fun delete(id: Int, authentication: Authentication): ResponseEntity<HttpStatus> {
        CompletableFuture.runAsync {
            println(if(userHealthRepository.deleteByIdAndUser(id, User(authentication)) == 1) "DELETE COMPLETE: id=$id"
            else "DELETE INCOMPLETE: id=$id")
        }
        return ResponseEntity.ok().build()
    }
}