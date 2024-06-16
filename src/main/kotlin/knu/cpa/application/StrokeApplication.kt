package knu.cpa.application

import knu.cpa.model.dto.stroke.res.StrokeGetElementRes
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication

interface StrokeApplication {
    fun getList(authentication: Authentication): ResponseEntity<List<StrokeGetElementRes>>
    fun get(strokeId: Int, authentication: Authentication): ResponseEntity<StrokeGetElementRes>
}