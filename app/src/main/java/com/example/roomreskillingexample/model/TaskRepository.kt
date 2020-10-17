package com.example.roomreskillingexample.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskRepository(private val mTaskDao : TaskDao) {

    // LiveData with all the table data
    val allTaskLiveData = mTaskDao.getAllTask()

    // Manage the coroutine in the repository
    fun insertTask(mTask: TaskEntity) = CoroutineScope(Dispatchers.IO).launch {
        mTaskDao.insertTask(mTask)
    }

    //Manage the coroutine in the ViewModel
     suspend fun insertTask01(mTask: TaskEntity) {
        mTaskDao.insertTask(mTask)
    }

     fun deleteAll() = CoroutineScope(Dispatchers.IO).launch {
        mTaskDao.deleteAllTask()
    }

}