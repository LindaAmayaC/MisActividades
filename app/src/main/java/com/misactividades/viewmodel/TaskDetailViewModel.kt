package com.misactividades.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misactividades.model.TaskModel
import com.misactividades.network.Callback
import com.misactividades.network.FirestoreService
import java.util.*

class TaskDetailViewModel : ViewModel(){
    val firestoreService = FirestoreService()
    var task : MutableLiveData<TaskModel> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun loadTask(taskToShow:TaskModel){
        task.postValue(taskToShow)
    }

    fun addTaskToFirebase(){
        val docUUID=UUID.randomUUID();
        val taskToInsert=TaskModel()

        taskToInsert.docName=docUUID.toString()
        taskToInsert.name=task.value?.name.toString()
        taskToInsert.description=task.value?.description.toString()

        firestoreService.createTask(object: Callback<Boolean>{
            override fun onSuccess(result: Boolean?) {
                Log.d("D","Inserted")
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                Log.d("D","Not Inserted")
                processFinished()
            }
        }, taskToInsert)
    }

    fun deleteTaskFirebase(){
        firestoreService.deleteTask(object: Callback<Boolean>{
            override fun onSuccess(result: Boolean?) {
                Log.d("D","Delete Task Sucessful")
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                Log.d("D","Not Delete")
                processFinished()
            }
        },task.value?.docName.toString())
    }


    private fun processFinished() {
        isLoading.value = true
    }
}