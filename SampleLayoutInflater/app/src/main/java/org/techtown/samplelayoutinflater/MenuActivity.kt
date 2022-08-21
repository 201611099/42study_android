package org.techtown.samplelayoutinflater

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class MenuActivity : AppCompatActivity() {
    lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        container = findViewById(R.id.container)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val inflater: LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.sub1, container, true)
            val checkBox: CheckBox = container.findViewById(R.id.checkBox)
            checkBox.setText("로딩되었어요.")
        })
    }
}
