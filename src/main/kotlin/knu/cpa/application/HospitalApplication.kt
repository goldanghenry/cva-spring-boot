package knu.cpa.application

import knu.cpa.model.dto.hospital.res.HospitalGetElementRes
import org.springframework.http.ResponseEntity

interface HospitalApplication {
    fun get(latitude: Float, longitude: Float, size: Int): ResponseEntity<List<HospitalGetElementRes>>
}