package com.example.webtoonapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.webtoonapp.MainFragment
import com.example.webtoonapp.WeeklyFragment
import com.example.webtoonapp.LatestFragment
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.webtoonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var context: Context? = null
    var binding: ActivityMainBinding? = null
    var mainFragment: MainFragment? = null
    var weeklyFragment: WeeklyFragment? = null
    var latestFragment: LatestFragment? = null
    var transaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        mainFragment = MainFragment()
        weeklyFragment = WeeklyFragment()
        latestFragment = LatestFragment()
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.replace(binding!!.flMain.id, mainFragment!!)
        transaction!!.commit()
        binding!!.ivLogo.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu1.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu2.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu3.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu4.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu5.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu6.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu7.setOnClickListener { view: View -> onClick(view) }
        binding!!.rbMenu8.setOnClickListener { view: View -> onClick(view) }
    }

    private fun onClick(view: View) {
        if (view.id == binding!!.ivLogo.id) {
            binding!!.rbMenu1.isChecked = false
            binding!!.rbMenu2.isChecked = false
            binding!!.rbMenu3.isChecked = false
            binding!!.rbMenu4.isChecked = false
            binding!!.rbMenu5.isChecked = false
            binding!!.rbMenu6.isChecked = false
            binding!!.rbMenu7.isChecked = false
            binding!!.rbMenu8.isChecked = false
            transaction = supportFragmentManager.beginTransaction()
            transaction!!.replace(binding!!.flMain.id, mainFragment!!)
            transaction!!.commit()
        }
        if (view.id == binding!!.rbMenu1.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu1.isChecked == true) {
                binding!!.rbMenu2.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, weeklyFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu2.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu2.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu3.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu3.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu2.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu4.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu4.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu2.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu5.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu5.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu2.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu6.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu6.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu2.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu7.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu7.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu2.isChecked = false
                binding!!.rbMenu8.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        } else if (view.id == binding!!.rbMenu8.id) {
            transaction = supportFragmentManager.beginTransaction()
            if (binding!!.rbMenu8.isChecked == true) {
                binding!!.rbMenu1.isChecked = false
                binding!!.rbMenu3.isChecked = false
                binding!!.rbMenu4.isChecked = false
                binding!!.rbMenu5.isChecked = false
                binding!!.rbMenu6.isChecked = false
                binding!!.rbMenu7.isChecked = false
                binding!!.rbMenu2.isChecked = false
                transaction!!.replace(binding!!.flMain.id, latestFragment!!)
                transaction!!.commit()
            }
        }
    }
}