package org.techtown.doitmission07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnCustomer: Button = findViewById(R.id.btnCustomer)
        val btnSales: Button = findViewById(R.id.btnSales)
        val btnProduct: Button = findViewById(R.id.btnProduct)

        btnCustomer.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, CustomerActivity::class.java)
            startActivity(intent)
        })

        btnSales.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, SalesActivity::class.java)
            startActivity(intent)
        })

        btnProduct.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        })
    }
}