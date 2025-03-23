package com.cavin.assistant.data

import java.time.LocalDateTime

data class AssistantData(
    val id: Int,
    val userId: String,  // Unique user identifier
    val name: String,
    val priority: Priority,
    var status: TaskStatus = TaskStatus.PENDING,
    val createdAt: LocalDateTime = LocalDateTime.now()
) : Comparable<AssistantData> {
    override fun equals(other: Any?): Boolean {
        return (other is AssistantData) && other.id == this.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun compareTo(other: AssistantData): Int {
        return when {
            this.priority != other.priority -> other.priority.ordinal - this.priority.ordinal
            else -> this.createdAt.compareTo(other.createdAt)
        }
    }
}


// enum class for the task status
enum class TaskStatus { PENDING, IN_PROGRESS, COMPLETE, COMPLETED }

// enum class for the priority
enum class Priority { HIGH, MIDDLE, LOW }
