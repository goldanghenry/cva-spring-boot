package knu.cpa.repository

import knu.cpa.model.entity.UserHealth
import org.springframework.data.jpa.repository.JpaRepository

interface UserHealthRepository: JpaRepository<UserHealth, Int> {
}