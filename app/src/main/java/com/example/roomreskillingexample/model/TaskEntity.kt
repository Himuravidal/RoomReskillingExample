package com.example.roomreskillingexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(@PrimaryKey(autoGenerate = true) val id : Int = 0,
                      val task: String,
                      val done : Boolean
)