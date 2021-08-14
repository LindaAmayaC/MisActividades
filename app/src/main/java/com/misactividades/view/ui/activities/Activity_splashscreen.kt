package com.misactividades

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.misactividades.view.ui.activities.MainActivity

class activity_splashscreen: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
