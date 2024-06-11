package knu.cpa.model.entity
import jakarta.persistence.*
@Entity
data class Stroke(
        @Id
        val id: Long,
        val userId:Long,

        var isStroke: Boolean? = null,
        var probability: Float? = null,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id")
        val userHealth: UserHealth? = null
)