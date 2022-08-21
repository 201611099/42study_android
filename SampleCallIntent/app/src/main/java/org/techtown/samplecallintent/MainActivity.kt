package org.techtown.samplecallintent

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.view.KeyEventDispatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 뷰 객체 참조

        val editText: EditText = findViewById(R.id.editText)
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            var data: String = editText.text.toString() // 입력 상자에 입력된 전화번호 확인
            val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(data)) // 전화걸기 화면을 보여줄 인텐트 객체 생성
            startActivity(intent)
        })

        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent()
            val componentName: ComponentName = ComponentName("org.techtown.samplecallintent", "org.techtown.samplecallintent.MenuActivity")
            intent.setComponent(componentName)
            startActivityForResult(intent, 101)
        })
    }
}