package org.techtown.mypager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.mytab.Fragement1
import org.techtown.mytab.Fragement2
import org.techtown.mytab.Fragement3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = PagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit = 3

        indicator.setViewPager(pager)
        indicator.createIndicators(3,0)

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                showToast("${position + 1} 페이지 선택됨")
                indicator.animatePageSelected(position)
            }
        })
        button.setOnClickListener {
            pager.currentItem = 0
        }
        button2.setOnClickListener {
            pager.currentItem = 1
        }
        button3.setOnClickListener {
            pager.currentItem = 2
        }
    }

    inner class PagerAdapter: FragmentStateAdapter {
        constructor(activity: FragmentActivity): super(activity)

        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            when(position) {
                0 -> return Fragement1()
                1 -> return Fragement2()
                2 -> return Fragement3()
            }
            return  Fragement1()
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}