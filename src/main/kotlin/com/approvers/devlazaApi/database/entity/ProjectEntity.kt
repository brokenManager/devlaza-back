package com.approvers.devlazaApi.database.entity

import com.approvers.devlazaApi.database.table.ProjectMembersTable
import com.approvers.devlazaApi.database.table.ProjectsTable
import com.approvers.devlazaApi.database.table.SitesTable
import com.approvers.devlazaApi.database.table.TagsWithProjects
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class ProjectEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object: UUIDEntityClass<ProjectEntity>(ProjectsTable)

    var name by ProjectsTable.name
    var introduction by ProjectsTable.introduction
    var createdAt by ProjectsTable.createdAt
    var owner by UserEntity referencedOn ProjectsTable.owner
    var recruitingState by ProjectsTable.recruitingState

    val sites by SiteEntity referrersOn  SitesTable.project
    val tags by TagEntity referrersOn TagsWithProjects.project
    val members by UserEntity referrersOn ProjectMembersTable.project
}