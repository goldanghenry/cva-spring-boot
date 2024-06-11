package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.StrokeApplication
import knu.cpa.model.dto.stroke.req.StrokeReqDto
import knu.cpa.model.dto.stroke.res.StrokeResDto
import knu.cpa.model.dto.stroke.res.StrokeResElementDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/stroke")
@Tag(name="뇌졸중")
class StrokePresentation(private val strokeApplication: StrokeApplication) {
    @GetMapping
    @Operation(summary = "모든 뇌졸중 정보")
    fun getStrokeList(authentication: Authentication):ResponseEntity<List<StrokeResElementDto>> {
        return strokeApplication.getStrokeList(authentication)
    }

    @GetMapping
    @Operation(summary = "단일 뇌졸중 정보")
    fun getStroke(@RequestParam("id") strokeId: Long, authentication: Authentication): ResponseEntity<StrokeResDto> {
        return strokeApplication.getStroke(strokeId, authentication)
    }

    @PatchMapping
    @Operation(summary = "뇌졸중 업데이트")
    fun patchStroke(@RequestBody strokeReqDto: StrokeReqDto, authentication: Authentication): ResponseEntity<HttpStatus> {
        return strokeApplication.patchStroke(strokeReqDto, authentication)
    }

    @DeleteMapping("/delete")
    @Operation(summary = "뇌졸중 정보 삭제")
    fun deleteUserHealth(@RequestParam("id") strokeId: Long, authentication: Authentication): ResponseEntity<HttpStatus> {
        return strokeApplication.deleteStroke(strokeId, authentication)
    }

}