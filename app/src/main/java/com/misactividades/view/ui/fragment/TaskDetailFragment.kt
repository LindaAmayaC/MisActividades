package com.misactividades.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.misactividades.R
import com.misactividades.model.TaskModel
import com.misactividades.viewmodel.TaskDetailViewModel
import kotlinx.android.synthetic.main.fragment_task_details.*

class TaskDetailFragment : DialogFragment() {
    private lateinit var viewModel:TaskDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskDetailViewModel::class.java)
        val mode= arguments?.getString("mode")

        //TODO y bindear el live data con la interfaz

        if(mode=="VIEW"){
            val task = arguments?.getSerializable("selectedTask") as TaskModel
            viewModel.loadTask(task)
            tvDetailsActivityname.text=task.name
            tvDetailsActivityname.isEnabled=false
            tvDetailsActivitydescription.setText(task.description)
            tvDetailsActivityname.isEnabled=false
        }
        if(mode=="CREATE"){
            viewModel.loadTask(TaskModel())
            //TODO Configurar la vista para que se pueda escribir nombre y descripcion, y hacer aparecer el boton de crear, añadiendole el listener que llamaria
            //TODO a el viewModel.createTaskonFirebase o algo asi
        }

    }
    override fun onStart(){
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }
}