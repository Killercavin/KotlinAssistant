package com.cavin.assistant.data

import java.time.LocalDate
import java.time.LocalDateTime

data class AssistantData(
    val id: Int,
    val name: String,
    var status: TaskStatus = TaskStatus.PENDING,
    var priority: Priority,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)

// enum class for the task status
enum class TaskStatus { PENDING, IN_PROGRESS, COMPLETE }

// enum class for the priority
enum class Priority { HIGH, MIDDLE, LOW }
