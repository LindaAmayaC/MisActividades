package com.misactividades.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.misactividades.model.TaskModel


const val TASKLIST_COLLECTION_NAME = "TaskList"
class FirestoreService {

    val firesbaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firesbaseFirestore.firestoreSettings = settings
    }

    fun getTaskList(callback: Callback<List<TaskModel>>){
        firesbaseFirestore.collection(TASKLIST_COLLECTION_NAME)
            .get()
            .addOnSuccessListener{ result ->
                for (taskdoc in result){
                    val list = result.toObjects(TaskModel::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun createTask(callback: Callback<Boolean>, task:TaskModel){
        firesbaseFirestore.collection(TASKLIST_COLLECTION_NAME)
            .document(task.docName).set(task)
            .addOnSuccessListener{ _ ->
                callback.onSuccess(true)
            }
            .addOnFailureListener{ _ ->
                callback.onSuccess(false)
            }

    }
}