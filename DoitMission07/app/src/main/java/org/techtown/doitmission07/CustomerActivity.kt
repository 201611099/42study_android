package org.techtown.doitmission07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        val btnMenu: Button = findViewById(R.id.btnGoMenuC)
        val btnLogin: Button = findViewById(R.id.btnGoLoginC)

        btnMenu.setOnClickListener(View.OnClickListener {
            finish()
        })
        btnLogin.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
    }
}