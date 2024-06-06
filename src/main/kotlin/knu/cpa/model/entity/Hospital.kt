package knu.cpa.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Hospital(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    var name: String,

    var latitude: Float?,

    var longitude: Float?,

    var address: String?,

    var contact: String?
)
