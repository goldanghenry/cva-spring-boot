package knu.cpa.application.impl

import knu.cpa.application.StrokeApplication
import knu.cpa.model.dto.stroke.req.StrokeReqDto
import knu.cpa.model.dto.stroke.res.StrokeResDto
import knu.cpa.model.dto.stroke.res.StrokeResElementDto
import knu.cpa.model.dto.userHealth.res.UserHealthResDto
import knu.cpa.model.entity.User
import knu.cpa.repository.StrokeRepository
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.http.*



@Service
class StrokeApplicationImpl (
        private val strokeRepository: StrokeRepository
) : StrokeApplication {
    override fun getStrokeList(authentication: Authentication): ResponseEntity<List<StrokeResElementDto>> {
        val userId = User(authentication).id
        val strokeList = strokeRepository.findAllByUserId(userId)

        val responseList = strokeList.map { StrokeResElementDto(it) }
        return ResponseEntity.ok(responseList)
    }

    override fun getStroke(strokeId: Long, authentication: Authentication): ResponseEntity<StrokeResDto> {
        val userId = User(authentication).id
        val stroke = strokeRepository.findByIdAndUserId(strokeId, userId)
                .orElseThrow { Exception("User health info not found") }
        return ResponseEntity.ok(StrokeResDto(stroke))
    }

    override fun patchStroke(strokeReqDto: StrokeReqDto, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userId = User(authentication).id
        val stroke = strokeRepository.findByIdAndUserId(strokeReqDto.id, userId)
                .orElseThrow { Exception("User health info not found") }

        stroke.isStroke = strokeReqDto.isStroke
        stroke.probability = strokeReqDto.probability

        strokeRepository.save(stroke)
        return ResponseEntity(HttpStatus.OK)
    }



    override fun deleteStroke(strokeId: Long, authentication: Authentication): ResponseEntity<HttpStatus> {
        val userId = User(authentication).id
        val stroke = strokeRepository.findByIdAndUserId(strokeId, userId)
                .orElseThrow { Exception("User health info not found") }

        strokeRepository.delete(stroke)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}