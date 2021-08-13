package com.misactividades.view.Adapter

import com.misactividades.model.TaskModel

interface ItemTaskListener {
    fun onItemClicked(task:TaskModel, position:Int)
}