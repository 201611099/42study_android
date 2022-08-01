package org.techtown.sampleframelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView

    var imageIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView) as ImageView
        imageView2 = findViewById(R.id.imageView2) as ImageView
    }

    fun onButtonClicked(view: View) {
        changeImage()
    }
    fun changeImage() {
        if (imageIndex == 0) {
            imageView.visibility = View.VISIBLE
            imageView2.visibility = View.INVISIBLE
            imageIndex = 1
        } else if (imageIndex == 1) {
            imageView.visibility = View.INVISIBLE
            imageView2.visibility = View.VISIBLE
            imageIndex = 0
        }
    }
}