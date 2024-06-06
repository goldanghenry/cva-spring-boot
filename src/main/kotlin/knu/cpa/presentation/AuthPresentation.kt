package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.AuthApplication
import knu.cpa.model.dto.auth.req.AuthPostReq
import knu.cpa.model.dto.auth.res.AuthGetRes
import knu.cpa.model.dto.auth.res.AuthLoginRes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
@Tag(name = "인증 및 유저")
class AuthPresentation (private val authApplication: AuthApplication){

    @GetMapping("/login")
    @Operation(hidden = true)
    fun getLogin(@RequestParam code: String): ResponseEntity<AuthLoginRes> {
        return authApplication.getLogin(code)
    }

    @PatchMapping("/login")
    @Operation(summary = "AccessToken 갱신 API", description = "RefreshToken 사용해서 AccessToken 갱신")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "성공", content = arrayOf(Content(schema = Schema(implementation = AuthLoginRes::class))))
    )
    fun patchLogin(@Parameter(hidden = true) @RequestHeader("Authorization") refreshToken: String): ResponseEntity<AuthLoginRes> {
        return authApplication.patchLogin(refreshToken)
    }

    @RequestMapping("/info", method = [RequestMethod.POST, RequestMethod.PUT])
    @Operation(summary = "사용자 기본정보 입력 API")
    @ApiResponses
    fun postInfo(@RequestBody authPostReq: AuthPostReq, @Parameter(hidden = true) authentication: Authentication): ResponseEntity<HttpStatus>{
        return authApplication.postInfo(authPostReq, authentication)
    }

    @GetMapping("/info")
    @Operation(summary = "사용자 기본정보 조회 API")
    fun getInfo(@Parameter(hidden = true) authentication: Authentication): ResponseEntity<AuthGetRes>{
        return authApplication.getInfo(authentication)
    }
}