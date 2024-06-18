package knu.cpa.repository

import knu.cpa.model.entity.HealthInfo
import knu.cpa.model.state.HealthState
import org.springframework.data.jpa.repository.JpaRepository

interface HealthInfoRepository: JpaRepository<HealthInfo, Int> {

    fun findByHealthState(healthState: HealthState): List<HealthInfo>
}