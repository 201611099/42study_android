package org.techtown.mytab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager.beginTransaction()) {
            val fragment1 = Fragement1()
            replace(R.id.container, fragment1)
            commit()
        }
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab1 -> {
                    showToast("첫번째 탭 선택됨")

                    with(supportFragmentManager.beginTransaction()) {
                        val fragement1 = Fragement1()
                        replace(R.id.container, fragement1)
                        commit()
                }
                return@setOnNavigationItemSelectedListener true
                }
                R.id.tab2 -> {
                    showToast("두번째 탭 선택됨")

                    with(supportFragmentManager.beginTransaction()) {
                        val fragement2 = Fragement2()
                        replace(R.id.container, fragement2)
                        commit()
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab3 -> {
                    showToast("세번째 탭 선택됨")

                    with(supportFragmentManager.beginTransaction()) {
                        val fragement3 = Fragement3()
                        replace(R.id.container, fragement3)
                        commit()
                    }
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}