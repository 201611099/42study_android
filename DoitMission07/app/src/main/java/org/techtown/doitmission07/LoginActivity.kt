package org.techtown.doitmission07

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var editID: EditText
    lateinit var editPwd: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editID = findViewById(R.id.editTextID)
        editPwd = findViewById(R.id.editTextPwd)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, MenuActivity::class.java)
            var tmpID: String? = editID.text.toString()
            if (tmpID == null)
                tmpID = ""
            var tmpPwd: String? = editPwd.text.toString()
            if (tmpPwd == null)
                tmpPwd = ""
            if (tmpID == "" || tmpPwd == "") {
                Toast.makeText(this, "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show()
            } else {
                startActivity(intent)
            }
        })
    }
    override fun onPause() {
        super.onPause()
        saveState()
    }

    override fun onResume() {
        super.onResume()
        restoreState()
    }
    fun saveState() {
        var tmpID: String? = editID.text.toString()
        if (tmpID == null)
            tmpID = ""
        var tmpPwd: String? = editPwd.text.toString()
        if (tmpPwd == null)
            tmpPwd = ""
        if (tmpID == "" || tmpPwd == "")
            Toast.makeText(this, "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show()
        else {
            val pref: SharedPreferences? = getSharedPreferences("pref", Activity.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref!!.edit()
            editor.putString("id", tmpID)
            editor.putString("pwd", tmpPwd)
            editor.commit()
        }
    }
    fun restoreState() {
        val pref: SharedPreferences? = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        if ((pref != null) && (pref.contains("id")) && (pref.contains("pwd"))) {
            val id: String? = pref.getString("id", "")
            val pwd: String? = pref.getString("pwd", "")
            editID.setText(id)
            editPwd.setText(pwd)
        }

    }
}