package org.techtown.samplelifecycle

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var nameInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Toast.makeText(this, "onCreate 호출됨", Toast.LENGTH_LONG).show();
        println("onCreate 호출됨")
        val btn: Button = findViewById(R.id.button)
        nameInput = findViewById(R.id.nameInput)
        btn.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        println("onStart 호출됨")

//        Toast.makeText(this, "onStart 호출됨", Toast.LENGTH_LONG).show();
    }

    override fun onStop() {
        super.onStop()
        println("onStop 호출됨")

//        Toast.makeText(this, "onStop 호출됨", Toast.LENGTH_LONG).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy 호출됨")

//        Toast.makeText(this, "onDestroy 호출됨", Toast.LENGTH_LONG).show();
    }

    override fun onPause() {
        super.onPause()
        println("onPause 호출됨")
        saveState()
//        Toast.makeText(this, "onPause 호출됨", Toast.LENGTH_LONG).show();
    }

    override fun onResume() {
        super.onResume()
        println("onResume 호출됨")
        restoreState()
//        Toast.makeText(this, "onResume 호출됨", Toast.LENGTH_LONG).show();
    }

    fun println(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        Log.d("Main", data)
    }

    fun restoreState() {
        val pref: SharedPreferences? = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        if ((pref != null) && (pref.contains("name"))) {
            val name: String? = pref.getString("name", "")
            nameInput.setText(name)
        }
    }

    fun saveState() {
        val pref: SharedPreferences? = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref!!.edit()
        editor.putString("name", nameInput.text.toString())
        editor.commit()
    }

    fun clearState() {
        val pref: SharedPreferences? = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref!!.edit()
        editor.clear()
        editor.commit()
    }
}