package knu.cpa.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import knu.cpa.application.HospitalApplication
import knu.cpa.model.dto.hospital.res.HospitalGetElementRes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hospital")
@Tag(name = "병원")
class HospitalPresentation(private val hospitalApplication: HospitalApplication){

    @GetMapping
    @Operation(summary = "가까운 병원 조회")
    @ApiResponses
    fun get(@RequestParam latitude: Float, @RequestParam longitude: Float, @RequestParam size: Int): ResponseEntity<List<HospitalGetElementRes>> {
        return hospitalApplication.get(latitude, longitude, size)
    }
}
