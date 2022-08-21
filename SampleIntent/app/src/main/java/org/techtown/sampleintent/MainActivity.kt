package org.techtown.sampleintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btnMenu)
        btn.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, MenuActivity::class.java) // https://juahnpop.tistory.com/212
            startActivityForResult(intent, 101)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            101 -> {
                showToast("메뉴 액티비티로부터의 응답, ${requestCode}, ${resultCode}")
                when (resultCode) {
                    RESULT_OK -> showToast("응답으로 전달된 name : "+ data!!.getStringExtra("name"))
                }
            }
        }
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}