package org.techtown.samplescrollview

import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView

class MainActivity : AppCompatActivity() {
    lateinit var scrollView: ScrollView
    lateinit var imageView: ImageView
    lateinit var bitmap: BitmapDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scrollView = findViewById(R.id.scrollView) as ScrollView
        imageView = findViewById(R.id.imageView) as ImageView
        scrollView.isHorizontalScrollBarEnabled = true

        var res: Resources = resources
        bitmap = res.getDrawable(R.drawable.framelayout) as BitmapDrawable
        var bitmapWidth: Int = bitmap.intrinsicWidth
        var bitmapHeight: Int = bitmap.intrinsicHeight

        imageView.setImageDrawable(bitmap)
        imageView.layoutParams.width = bitmapWidth
        imageView.layoutParams.height = bitmapHeight
    }

    fun onButtonClicked(v: View) {
        changeImage()
    }

    fun changeImage() {
        var res: Resources = resources
        bitmap = res.getDrawable(R.drawable.tablelayout) as BitmapDrawable
        var bitmapWidth: Int = bitmap.intrinsicWidth
        var bitmapHeight: Int = bitmap.intrinsicHeight

        imageView.setImageDrawable(bitmap)
        imageView.layoutParams.width = bitmapWidth
        imageView.layoutParams.height = bitmapHeight
    }
}