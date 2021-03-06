package dev.approvers.devlazaApi.domain.data

import dev.approvers.devlazaApi.infra.table.RecruitingState
import java.time.LocalDateTime
import java.util.UUID

data class Project(
    val id: UUID? = null,
    var name: String,
    var introduction: String,
    val createdAt: LocalDateTime,
    var owner: User,
    var recruitingState: RecruitingState
)
