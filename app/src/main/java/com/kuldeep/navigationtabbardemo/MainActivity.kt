package com.kuldeep.navigationtabbardemo

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kuldeep.navigationtabbardemo.fragments.DashboardFragment
import com.kuldeep.navigationtabbardemo.fragments.InfoFragment
import com.kuldeep.navigationtabbardemo.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dashboardFragment= DashboardFragment()
    private val settingsFragment= SettingsFragment()
    private val infoFragment= InfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(dashboardFragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
               R.id.dashboard -> replaceFragment(dashboardFragment)
                R.id.settings -> replaceFragment(settingsFragment)
                R.id.info -> replaceFragment(infoFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!==null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,fragment)
            transaction.commit()
        }
    }
}