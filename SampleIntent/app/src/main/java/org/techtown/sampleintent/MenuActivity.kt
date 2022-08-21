package org.techtown.sampleintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn: Button = findViewById(R.id.button) // 버튼 객체 참조
        btn.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent();
            intent.putExtra("name", "mike") // 인텐트 객체 생성하고 name의 값을 부가 데이터로 넣기
            setResult(RESULT_OK, intent) // 응답 보내기
            finish() // 현재 액티비티 없애기
        })
    }
}