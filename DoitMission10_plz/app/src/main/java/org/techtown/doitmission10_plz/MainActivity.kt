package org.techtown.doitmission10_plz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    enum class FragmentItem {
        ITEM1, ITEM2, ITEM3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = PagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit = 3

        indicator.setViewPager(pager)
        indicator.createIndicators(3, 0)

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                showToast("메뉴 ${position + 1} 선택됨")
                indicator.animatePageSelected(position)
                toolbar.title = "메뉴 ${position + 1}"
            }
        })

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> {
                    pager.currentItem = 0
                }
                R.id.item2 -> {
                    pager.currentItem = 1
                }
                R.id.item3 -> {
                    pager.currentItem = 2
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        bottomView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.tab1 -> {
                    pager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab2 -> {
                    pager.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab3 -> {
                    pager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    inner class PagerAdapter: FragmentStateAdapter {
        constructor(activity: FragmentActivity): super(activity)

        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            when(position) {
                0 -> return Fragment1()
                1 -> return Fragment2()
                2 -> return Fragment3()
            }
            return Fragment1()
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}