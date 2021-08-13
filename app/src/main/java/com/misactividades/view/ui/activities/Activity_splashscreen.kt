package com.misactividades

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.misactividades.view.ui.activities.TaskListActivity

class activity_splashscreen: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val intent = Intent(this, TaskListActivity::class.java)
        startActivity(intent)
    }
}
