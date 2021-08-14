package com.misactividades.view.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.misactividades.R
import com.misactividades.model.TaskModel
import com.misactividades.viewmodel.TaskDetailViewModel
import kotlinx.android.synthetic.main.card_view_readable.*
import kotlinx.android.synthetic.main.fragment_task_details.*
import kotlinx.android.synthetic.main.fragment_task_list.*


class TaskDetailFragment : Fragment(){
    private lateinit var viewModel:TaskDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskDetailViewModel::class.java)
        val mode = arguments?.getString("mode")

        ivbuttomBack.setOnClickListener{
            onBackButtomClicked()
        }


        if(mode=="VIEW"){
            val task = arguments?.getSerializable("selectedTask") as TaskModel
            val inflater = LayoutInflater.from(context)
            val cardView = inflater.inflate(R.layout.card_view_readable, flCardContainer, true) as FrameLayout
            val name= cardView.findViewById(R.id.tvDetailsActivityName) as TextView
            val description= cardView.findViewById(R.id.tvDetailsActivityDescription) as TextView
            name.text=task.name
            description.text=task.description
            viewModel.loadTask(task)
            ivbuttomDelete.setOnClickListener {
                onDeleteButtonClicked()
            }
        }
        if(mode=="CREATE"){
            viewModel.loadTask(TaskModel())
            //TODO Configurar la vista para que se pueda escribir nombre y descripcion, y hacer aparecer el boton de crear, añadiendole el listener que llamaria
            //TODO a el viewModel.createTaskonFirebase o algo asi
        }

    }
    fun onDeleteButtonClicked(){
        viewModel.deleteTaskFirebase()
        onBackButtomClicked()
        Log.d("D","entro a deletebuttom")
    }
    fun onBackButtomClicked(){
        parentFragmentManager.beginTransaction().replace(R.id.flMainContainer, TaskListFragment()).commit()
        parentFragmentManager.beginTransaction().remove(this).commit()
        onDestroy()
    }
}