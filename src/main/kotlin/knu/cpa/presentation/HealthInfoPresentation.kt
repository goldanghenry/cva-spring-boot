package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.HealthInfoApplication
import knu.cpa.model.dto.healthInfo.res.HealthInfoGetElementRes
import knu.cpa.model.dto.healthInfo.res.HealthInfoGetRes
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/healthInfo")
@Tag(name = "건강 정보")
class HealthInfoPresentation(private val healthInfoApplication: HealthInfoApplication){

    @GetMapping("/list")
    @Operation(summary = "리스트 조회")
    fun getList(@Parameter(hidden = true) authentication: Authentication): ResponseEntity<List<HealthInfoGetElementRes>> {
        return healthInfoApplication.getList(authentication)
    }

    @GetMapping
    @Operation(summary = "HealthInfo 상세 조회")
    fun get(@RequestParam id: Int, @Parameter(hidden = true) authentication: Authentication): ResponseEntity<HealthInfoGetRes>{
        return healthInfoApplication.get(id, authentication)
    }
}