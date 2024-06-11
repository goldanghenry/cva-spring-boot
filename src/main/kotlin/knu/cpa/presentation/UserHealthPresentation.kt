package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.UserHealthApplication
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import knu.cpa.model.dto.userHealth.res.UserHealthReqDto
import knu.cpa.model.dto.userHealth.res.UserHealthResDto
import knu.cpa.model.dto.userHealth.res.UserHealthResElementDto

@RestController
@RequestMapping("api/userHealth")
@Tag(name = "유저정보")
class UserHealthPresentation(private val userHealthApplication: UserHealthApplication) {

    @GetMapping
    @Operation(summary = "모든 건강 정보")
    fun getUserHealthList(authentication: Authentication): ResponseEntity<List<UserHealthResElementDto>> {
        return userHealthApplication.getUserHealthList(authentication)
    }

    @GetMapping("/get")
    @Operation(summary = "단일 건강 정보")
    fun getUserHealth(@RequestParam("id") userHealthId: Long, authentication: Authentication): ResponseEntity<UserHealthResDto> {
        return userHealthApplication.getUserHealth(userHealthId, authentication)
    }

    @PostMapping
    @Operation(summary = "건강 정보 추가")
    fun postUserHealth(@RequestBody userHealthReqDto: UserHealthReqDto, authentication: Authentication): ResponseEntity<HttpStatus> {
        return userHealthApplication.postUserHealth(userHealthReqDto, authentication)
    }

    @PatchMapping
    @Operation(summary = "건강 정보 수정")
    fun patchUserHealth(@RequestBody userHealthReqDto: UserHealthReqDto, authentication: Authentication): ResponseEntity<HttpStatus> {
        return userHealthApplication.patchUserHealth(userHealthReqDto, authentication)
    }

    @DeleteMapping("/delete")
    @Operation(summary = "건강 정보 삭제")
    fun deleteUserHealth(@RequestParam("id") userHealthId: Long, authentication: Authentication): ResponseEntity<HttpStatus> {
        return userHealthApplication.deleteUserHealth(userHealthId, authentication)
    }
}
