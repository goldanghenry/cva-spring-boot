package knu.cpa.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
data class Stroke(
    @Id
    var id: Int?,

    @OneToOne
    var userHealth: UserHealth,

    var probability: Float,

    var isWeight: Boolean,

    var isAge: Boolean,

    var isBloodPressure: Boolean,

    var isHeartDisease: Boolean
)
