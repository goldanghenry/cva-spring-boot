package knu.cpa.application

import knu.cpa.model.dto.stroke.req.StrokeReqDto
import knu.cpa.model.dto.stroke.res.StrokeResDto
import knu.cpa.model.dto.stroke.res.StrokeResElementDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication

interface StrokeApplication {
    fun getStrokeList(authentication: Authentication): ResponseEntity<List<StrokeResElementDto>>
    fun getStroke(strokeId: Long, authentication: Authentication): ResponseEntity<StrokeResDto>
    fun patchStroke(strokeReqDto: StrokeReqDto, authentication: Authentication): ResponseEntity<HttpStatus>
    fun deleteStroke(strokeId: Long, authentication: Authentication): ResponseEntity<HttpStatus>
}