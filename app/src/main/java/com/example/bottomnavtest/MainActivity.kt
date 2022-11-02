package com.example.bottomnavtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav : NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        bottomNav = findViewById(R.id.bottom_navigation_view)


    bottomNav.setOnItemSelectedListener {

        when(it.itemId) {

            R.id.mi_home -> setCurrentFragment(firstFragment)
            R.id.mi_messages -> setCurrentFragment(secondFragment)
            R.id.mi_profile -> setCurrentFragment(thirdFragment)
        }
        true
    }
}

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
}