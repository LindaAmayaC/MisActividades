package com.misactividades.view.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.misactividades.R
import com.misactividades.model.TaskModel

class TaskAdapter (val itemTaskListener: ItemTaskListener) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    var listTask = ArrayList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
    )

    override fun getItemCount() = listTask.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tasks = listTask[position]
        holder.tvTaskName.text = tasks.name

        holder.itemView.setOnClickListener{
            itemTaskListener.onItemClicked(tasks, position)
        }
    }

    fun updateData(data: List<TaskModel>){
        listTask.clear()
        listTask.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder (itemView : View)  : RecyclerView.ViewHolder(itemView){
        val tvTaskName = itemView.findViewById<TextView>(R.id.tvDetailsActivityname)
    }
}