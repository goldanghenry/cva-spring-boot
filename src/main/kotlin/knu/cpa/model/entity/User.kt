package knu.cpa.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.security.core.Authentication
import java.time.LocalDate

@Entity
data class User(
    @Id
    var id: Long,

    @Column(length = 20)
    var name: String?,

    var profileImg: String?,

    var birthday: LocalDate?,

    var gender: Boolean?
){
    constructor(id: Long): this(id, null, null, null, null)
    constructor(authentication: Authentication): this(id = authentication.name.toLong())
}
