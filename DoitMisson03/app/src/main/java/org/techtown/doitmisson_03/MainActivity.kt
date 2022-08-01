package org.techtown.doitmisson_03

import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView

class MainActivity : AppCompatActivity() {
    lateinit var scrollView: ScrollView
    lateinit var scrollView2: ScrollView
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView
    lateinit var bitmap: BitmapDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scrollView = findViewById(R.id.scrollView) as ScrollView
        scrollView2 = findViewById(R.id.scrollView2) as ScrollView
        imageView = findViewById(R.id.imageView) as ImageView
        imageView2 = findViewById(R.id.imageView2) as ImageView
        scrollView.isHorizontalScrollBarEnabled = true
        scrollView.isVerticalScrollBarEnabled = true
        scrollView2.isVerticalScrollBarEnabled = true
        scrollView2.isHorizontalScrollBarEnabled = true

        var res: Resources = resources
        bitmap = res.getDrawable(R.drawable.framelayout) as BitmapDrawable
        val bitmapWidth: Int = bitmap.intrinsicWidth
        val bitmapHeight: Int = bitmap.intrinsicHeight

        imageView.setImageDrawable(bitmap);
        imageView.layoutParams.width = bitmapWidth
        imageView.layoutParams.height = bitmapHeight
    }

    fun onUpButtonClicked(v: View)
    {
        changeUpImage()
    }

    fun onDownButtonClicked(v: View)
    {
        changeDownImage()
    }

    fun changeUpImage() {
        var res: Resources = resources
        bitmap = res.getDrawable(R.drawable.framelayout) as BitmapDrawable
        val bitmapWidth: Int = bitmap.intrinsicWidth
        val bitmapHeight: Int = bitmap.intrinsicHeight

        imageView.setImageDrawable(bitmap);
        imageView.layoutParams.width = bitmapWidth
        imageView.layoutParams.height = bitmapHeight
        imageView2.visibility = View.INVISIBLE
        imageView.visibility = View.VISIBLE

    }
    fun changeDownImage() {
        var res: Resources = resources
        bitmap = res.getDrawable(R.drawable.framelayout) as BitmapDrawable
        val bitmapWidth: Int = bitmap.intrinsicWidth
        val bitmapHeight: Int = bitmap.intrinsicHeight

        imageView2.setImageDrawable(bitmap);
        imageView2.layoutParams.width = bitmapWidth
        imageView2.layoutParams.height = bitmapHeight
        imageView.visibility = View.INVISIBLE
        imageView2.visibility = View.VISIBLE
    }
}