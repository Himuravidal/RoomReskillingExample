package com.example.roomreskillingexample.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    // insert only one task
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertTask(mTask: TaskEntity)

    // Insert a list of task
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListTask(mListTask: List<TaskEntity>)

    @Update
    fun updateOneTask(mTask: TaskEntity)

    @Delete
    fun deleteOneTask(mTask: TaskEntity)

    @Query("DELETE FROM task_table")
    fun deleteAllTask()

    // bring all data from table
    @Query("SELECT * FROM task_table")
    fun getAllTask() : LiveData<List<TaskEntity>>

}