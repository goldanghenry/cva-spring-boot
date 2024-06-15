package knu.cpa.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
data class Stroke(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @OneToOne
    var userHealth: UserHealth,

    var probability: Float,

    var isWeight: Boolean,

    var isAge: Boolean,

    var isBloodPressure: Boolean,

    var isHeartDisease: Boolean
)
