package org.techtown.mydrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.mytab.Fragement1
import org.techtown.mytab.Fragement2
import org.techtown.mytab.Fragement3

class MainActivity : AppCompatActivity() {
    enum class FragmentItem {
        ITEM1, ITEM2, ITEM3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "첫번째 선택됨", Toast.LENGTH_LONG).show()
                    onFragmentSelected(FragmentItem.ITEM1, null)
                }

                R.id.item2 -> {
                    Toast.makeText(this, "두번째 선택됨", Toast.LENGTH_LONG).show()
                    onFragmentSelected(FragmentItem.ITEM2, null)
                }

                R.id.item3 -> {
                    Toast.makeText(this, "세번째 선택됨", Toast.LENGTH_LONG).show()
                    onFragmentSelected(FragmentItem.ITEM3, null)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
        supportFragmentManager.beginTransaction().add(R.id.container, Fragement1()).commit()
    }
    fun onFragmentSelected(item:FragmentItem, bundle: Bundle?) {
        var fragment: Fragment
        when(item) {
            FragmentItem.ITEM1 -> {
                toolbar.title = "첫번째 화면"
                fragment = Fragement1()
            }

            FragmentItem.ITEM2 -> {
                toolbar.title = "두번째 화면"
                fragment = Fragement2()
            }

            FragmentItem.ITEM3 -> {
                toolbar.title = "세번째 화면"
                fragment = Fragement3()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}