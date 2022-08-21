package org.techtown.doitmission07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnCustomer: Button = findViewById(R.id.btnCustomer)
        val btnSales: Button = findViewById(R.id.btnSales)
        val btnProduct: Button = findViewById(R.id.btnProduct)

        btnCustomer.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, CustomerActivity::class.java)
            Toast.makeText(this, "고객 관리", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })

        btnSales.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, SalesActivity::class.java)
            Toast.makeText(this, "매출 관리", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })

        btnProduct.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, ProductActivity::class.java)
            Toast.makeText(this, "상품 관리", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })
    }
}