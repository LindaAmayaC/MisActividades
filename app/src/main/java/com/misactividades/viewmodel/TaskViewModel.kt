package com.misactividades.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misactividades.model.TaskModel

class TaskViewModel : ViewModel(){

    val taskModel = MutableLiveData<List<TaskModel>>()

    fun populateLiveData(){
        taskModel.postValue(getTaskList())
    }

    fun getTaskList (): List<TaskModel>{
        return listOf(
            TaskModel(name = "Cocinar", description="meowD"),
            TaskModel(name = "Hacer aseo", description="meowD"),
            TaskModel(name = "Planchar", description="meowD"),
            TaskModel(name = "Jugar videojuegos", description="meowD"),
            TaskModel(name = "Sacar a Piwis" , description="meowD")
        )
    }
}