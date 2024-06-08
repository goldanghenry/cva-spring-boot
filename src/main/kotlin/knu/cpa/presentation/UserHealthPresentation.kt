package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.UserHealthApplication
import knu.cpa.model.dto.userHealth.req.UserHealthPostReq
import knu.cpa.model.dto.userHealth.res.UserHealthGetElementRes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/userHealth")
@Tag(name = "유저 건강")
class UserHealthPresentation(private val userHealthApplication: UserHealthApplication) {

    @PostMapping
    @Operation(summary = "유저 건강 정보 작성")
    @ApiResponses
    fun post(@RequestBody userHealthPostReq: UserHealthPostReq, @Parameter(hidden = true) authentication: Authentication): ResponseEntity<HttpStatus> {
        return userHealthApplication.post(userHealthPostReq, authentication)
    }

    @GetMapping("/list")
    @Operation(summary = "유저 건강 정보 리스트 조회")
    @ApiResponses
    fun getList(@RequestParam pageNumber: Int, @RequestParam pageSize: Int, @Parameter(hidden = true) authentication: Authentication): ResponseEntity<List<UserHealthGetElementRes>>{
        return userHealthApplication.getList(pageNumber, pageSize, authentication)
    }
}