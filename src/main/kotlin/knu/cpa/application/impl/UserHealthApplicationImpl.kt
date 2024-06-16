package knu.cpa.application.impl

import com.fasterxml.jackson.databind.ObjectMapper
import knu.cpa.application.UserHealthApplication
import knu.cpa.model.dto.stroke.req.StrokeGetReq
import knu.cpa.model.dto.stroke.res.StrokeGetRes
import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import knu.cpa.model.dto.userHealth.res.UserHealthGetElementRes
import knu.cpa.model.dto.userHealth.res.UserHealthGetRes
import knu.cpa.model.entity.Stroke
import knu.cpa.model.entity.User
import knu.cpa.model.entity.UserHealth
import knu.cpa.repository.StrokeRepository
import knu.cpa.repository.UserHealthRepository
import knu.cpa.repository.UserRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.PageRequest
import org.springframework.http.*
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate
import java.time.Period
import java.util.concurrent.CompletableFuture

@Service
class UserHealthApplicationImpl(
    private val userHealthRepository: UserHealthRepository,
    private val strokeRepository: StrokeRepository,
    private val userRepository: UserRepository,
    @Value("\${fastApi}")
    private val fastApiServer: String,
    private val objectMapper: ObjectMapper) : UserHealthApplication{
    override fun post(userHealthPostReq: UserHealthPostReq, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userHealth = userHealthRepository.save(UserHealth(userHealthPostReq, User(authentication)))

        var age = 0
        var bmi = 0F

        CompletableFuture.supplyAsync {
            userRepository.findById(authentication.name.toLong()).orElseThrow()
        }.thenApplyAsync {
            age = Period.between(it.birthday, LocalDate.now()).years
            bmi = (userHealthPostReq.weight)/((userHealthPostReq.height * userHealthPostReq.height) / 10000)
            objectMapper.writeValueAsString(StrokeGetReq(it, userHealthPostReq))
        }.thenApply {
            val httpHeaders = HttpHeaders()
            httpHeaders.contentType = MediaType.APPLICATION_JSON
            HttpEntity(it, httpHeaders)
        }.thenApplyAsync {
            RestTemplate().postForEntity("$fastApiServer/predict_stroke", it, StrokeGetRes::class.java)
        }.thenApplyAsync {
            strokeRepository.save(
                Stroke(id = null,
                    userHealth = userHealth,
                    probability = it.body?.stroke_probability ?: 0F,
                    isWeight = (bmi > 25 || bmi < 18.5),
                    isAge = age > 50,
                    isBloodPressure = userHealthPostReq.highBloodPressure,
                    isHeartDisease = userHealthPostReq.heartDisease
                ))
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