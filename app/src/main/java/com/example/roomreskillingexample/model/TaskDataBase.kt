package com.example.roomreskillingexample.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {
    //dao
    abstract fun taskDao() : TaskDao

    companion object {
        @Volatile
        private var INSTANCE : TaskDataBase? = null

        fun getDatabase(context: Context): TaskDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    TaskDataBase::class.java,
                    "task_db")
                    .build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}