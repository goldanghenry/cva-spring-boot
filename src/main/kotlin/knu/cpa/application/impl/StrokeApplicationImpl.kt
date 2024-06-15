package knu.cpa.application.impl

import knu.cpa.application.StrokeApplication
import knu.cpa.model.dto.stroke.res.StrokeGetElementRes
import knu.cpa.model.entity.User
import knu.cpa.repository.StrokeRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class StrokeApplicationImpl(private val strokeRepository: StrokeRepository): StrokeApplication {
    override fun getList(authentication: Authentication): ResponseEntity<List<StrokeGetElementRes>> {
        return ResponseEntity.ok(
        strokeRepository.findByUser(User(authentication)).map {
            StrokeGetElementRes(it)
        })
    }
}