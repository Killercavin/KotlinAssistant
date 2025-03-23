package com.cavin.assistant.services

import com.cavin.assistant.data.AssistantData
import com.cavin.assistant.data.TaskStatus
import org.slf4j.LoggerFactory

class TaskAnalytics {
    private val logger = LoggerFactory.getLogger(TaskAnalytics::class.java)

    // Calculate total tasks
    fun getTotalTasks(tasks: Set<AssistantData>): Int {
        val count = tasks.size
        logger.info("📊 Total tasks: {}", count)
        return count
    }

    // Calculate completed tasks
    fun getCompletedTasks(tasks: Set<AssistantData>): Int {
        val count = tasks.count { it.status == TaskStatus.COMPLETED }
        logger.info("✔ Completed tasks: {}", count)
        return count
    }

    // Calculate pending tasks
    fun getPendingTasks(tasks: Set<AssistantData>): Int {
        val count = tasks.count { it.status == TaskStatus.PENDING }
        logger.info("🕒 Pending tasks: {}", count)
        return count
    }
}
