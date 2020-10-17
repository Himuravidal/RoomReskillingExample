package com.example.roomreskillingexample.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomreskillingexample.model.TaskDataBase
import com.example.roomreskillingexample.model.TaskEntity
import com.example.roomreskillingexample.model.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application){

    private val mTaskRepository : TaskRepository
    val allTask : LiveData<List<TaskEntity>>
    init {
        val dao = TaskDataBase.getDatabase(application).taskDao()
        mTaskRepository = TaskRepository(dao)
        allTask = mTaskRepository.allTaskLiveData
    }

    fun insertOptionOne(mtask : TaskEntity) {
        mTaskRepository.insertTask(mtask)
    }

    fun insertOptionTwo(mtask: TaskEntity) = viewModelScope.launch {
        mTaskRepository.insertTask01(mtask)
    }

    fun deleteAll() {
        mTaskRepository.deleteAll()
    }


}