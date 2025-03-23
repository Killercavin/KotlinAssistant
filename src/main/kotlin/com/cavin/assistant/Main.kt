package com.cavin.assistant

import com.cavin.assistant.data.Priority
import com.cavin.assistant.data.TaskStatus
import com.cavin.assistant.services.TaskManager

fun main() {
    val taskManager = TaskManager()

    // Users
    val user1 = "user123"
    val user2 = "user456"

    // Add tasks for different users
    taskManager.addTask(user1, "Finish Kotlin project", Priority.HIGH)
    taskManager.addTask(user1, "Clean the house", Priority.LOW)
    taskManager.addTask(user2, "Prepare for meeting", Priority.HIGH)
    taskManager.addTask(user2, "Watch a movie", Priority.LOW)

    // List tasks for each user
    taskManager.listUserTasks(user1)
    taskManager.listUserTasks(user2)

    // Get next task for user1
    taskManager.getNextTask(user1)

    // Update task status
    taskManager.updateTaskStatus(user2, 3, TaskStatus.COMPLETED)

    // List updated tasks
    taskManager.listUserTasks(user1)
    taskManager.listUserTasks(user2)
}
