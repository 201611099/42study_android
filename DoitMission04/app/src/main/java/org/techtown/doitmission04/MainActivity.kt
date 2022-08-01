package org.techtown.doitmission04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText) as EditText
        textView = findViewById(R.id.textView) as TextView
        editText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var bytes: ByteArray?
                bytes = p0.toString().toByteArray(Charset.defaultCharset())
                textView.setText("${bytes.size} / 80 바이트")
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    fun onSubmitBtnClicked(v: View) {
        showToast()
    }

    fun showToast() {
        var msg: String = editText.text.toString()
        Toast.makeText(applicationContext, "전송할 메시지\n$msg", Toast.LENGTH_LONG).show()
    }
}