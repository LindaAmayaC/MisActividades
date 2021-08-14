package com.misactividades.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.misactividades.R
import com.misactividades.model.TaskModel
import com.misactividades.view.Adapter.ItemTaskListener
import com.misactividades.view.Adapter.TaskAdapter
import com.misactividades.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_task_list.*


class TaskListFragment : Fragment(), ItemTaskListener {

    private lateinit var taskAdapter : TaskAdapter
    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskAdapter = TaskAdapter(this)

        rvTasksList.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        rvTasksList.adapter = taskAdapter

        observeViewModel()
        viewModel.refresh()

    }

    private fun observeViewModel() {
        viewModel.listTask.observe(viewLifecycleOwner, Observer { data ->
            taskAdapter.updateData(data)
        })
    }

    override fun onItemClicked(task: TaskModel, position: Int) {
        val bundle = bundleOf("selectedTask" to task, "mode" to "VIEW")
        val detailFragment = TaskDetailFragment()
        detailFragment.arguments = bundle

        parentFragmentManager.beginTransaction().replace(R.id.flMainContainer, detailFragment).commit()
        parentFragmentManager.beginTransaction().remove(this).commit()
        onDestroy()
    }
}