package com.cavin.assistant.services

import com.cavin.assistant.data.AssistantData
import com.cavin.assistant.data.Priority
import com.cavin.assistant.data.TaskStatus
import org.slf4j.LoggerFactory
import java.util.PriorityQueue

class TaskManager {
    private val logger = LoggerFactory.getLogger(TaskManager::class.java)

    private var nextId = 1
    private val userTasks = mutableMapOf<String, MutableSet<AssistantData>>()
    private val userTaskQueues = mutableMapOf<String, PriorityQueue<AssistantData>>()

    // Add a task for a specific user
    fun addTask(userId: String, name: String, priority: Priority) {
        val task = AssistantData(id = nextId++, userId = userId, name = name, priority = priority)

        userTasks.computeIfAbsent(userId) { mutableSetOf() }.add(task)
        userTaskQueues.computeIfAbsent(userId) { PriorityQueue() }.add(task)

        logger.info("✅ Task added for user {}: {}", userId, task)
    }

    // Get the next task for a specific user
    fun getNextTask(userId: String): AssistantData? {
        val queue = userTaskQueues[userId]
        return if (!queue.isNullOrEmpty()) {
            val nextTask = queue.poll()
            userTasks[userId]?.remove(nextTask)
            logger.info("🚀 Next task retrieved for user {}: {}", userId, nextTask)
            nextTask
        } else {
            logger.info("📭 No tasks available for user {}", userId)
            null
        }
    }

    // List tasks for a specific user
    fun listUserTasks(userId: String) {
        val tasks = userTasks[userId]
        if (tasks.isNullOrEmpty()) {
            logger.info("📭 No tasks available for user {}", userId)
        } else {
            logger.info("📌 Tasks for user {}:", userId)
            tasks.forEach { logger.info(it.toString()) }
        }
    }

    // Update task status for a specific user
    fun updateTaskStatus(userId: String, taskId: Int, status: TaskStatus) {
        val task = userTasks[userId]?.find { it.id == taskId }
        if (task != null) {
            userTasks[userId]?.remove(task)
            val updatedTask = task.copy(status = status)
            userTasks[userId]?.add(updatedTask)
            logger.info("🔄 Task updated for user {}: {}", userId, updatedTask)
        } else {
            logger.warn("❌ Task with ID {} not found for user {}", taskId, userId)
        }
    }
}
