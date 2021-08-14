package com.misactividades.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misactividades.model.TaskModel
import com.misactividades.network.Callback
import com.misactividades.network.FirestoreService
import java.lang.Exception

class TaskViewModel : ViewModel(){
    val firestoreService = FirestoreService()
    var listTask : MutableLiveData<List<TaskModel>> = MutableLiveData()


    fun refresh(){
        getListTaskFromFirebase()
    }

    private fun getListTaskFromFirebase() {
        firestoreService.getTaskList(object: Callback<List<TaskModel>>{
            override fun onSuccess(result: List<TaskModel>?) {
                listTask.postValue(result)
            }

            override fun onFailed(exception: Exception) {
            }
        })
    }

}