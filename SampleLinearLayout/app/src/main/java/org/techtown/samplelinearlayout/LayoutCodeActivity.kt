package org.techtown.samplelinearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Button

class LayoutCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mainLayout: LinearLayout = LinearLayout(this)
        mainLayout.orientation = LinearLayout.VERTICAL

        var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                                            LinearLayout.LayoutParams.WRAP_CONTENT)
        var button1: Button = Button(this)
        button1.setText("Button1")
        button1.layoutParams = params
        mainLayout.addView(button1)

        setContentView(mainLayout)
    }
}