package com.example.curriculumvitaev22

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MyCareerActivity : AppCompatActivity() {

    private  lateinit var btnExperience : Button
    private  lateinit var btnEducation : Button
    private  lateinit var fragmentContainer : FragmentContainerView


    private lateinit var infoBundle : Bundle
    lateinit var fragmentTransaction: FragmentTransaction
    lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_career)

        val toolbar: Toolbar =findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar=supportActionBar
        actionBar?.hide()
        actionBar?.show()

        // showing the back button in action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        btnExperience = findViewById(R.id.buttonExperience)
        btnEducation = findViewById(R.id.buttonEducation)
        fragmentContainer = findViewById(R.id.fragment_container)

        btnExperience.setOnClickListener {

            changeFragment(ExperienceFragment(),"")
        }

        btnEducation.setOnClickListener {

            changeFragment(EducationFragment(),"")
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ExperienceFragment()).commit()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return true
    }

    // this event will enable the back
    // function to the button on pressd
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.add_education ->{
                println("add_education")
            }
            R.id.add_experience ->{
                println("add_experience")
            }


        }
        return super.onContextItemSelected(item)
    }


    private fun changeFragment(fragment: Fragment, name: String) {
        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(name).commit()

    }

}