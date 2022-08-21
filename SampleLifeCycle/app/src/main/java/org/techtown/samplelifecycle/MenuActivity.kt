package org.techtown.samplelifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btn2: Button = findViewById(R.id.button2)

        btn2.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}