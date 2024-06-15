package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.StrokeApplication
import knu.cpa.model.dto.stroke.res.StrokeGetElementRes
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stroke")
@Tag(name = "예측")
class StrokePresentation(private val strokeApplication: StrokeApplication) {

    @GetMapping("/list")
    @Operation(summary = "뇌졸중 확률 예측 리스트 조회")
    @ApiResponse(responseCode = "200", description = "성공", content = [Content(schema = Schema(implementation = StrokeGetElementRes::class))])
    fun getList(@Parameter(hidden = true) authentication: Authentication): ResponseEntity<List<StrokeGetElementRes>> {
        return strokeApplication.getList(authentication)
    }
}