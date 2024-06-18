package knu.cpa.model.entity

import jakarta.persistence.*
import knu.cpa.model.state.HealthState

@Entity
data class HealthInfo(
    @Id
    var id: Int,

    var title: String,

    @Column(length = 5000)
    var content: String,

    var photo: String,

    var url: String,

    @Enumerated(EnumType.STRING)
    var healthState: HealthState
)
