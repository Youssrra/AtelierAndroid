package com.example.curriculumvitaev22

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class AboutMeActivity : AppCompatActivity() {

    private lateinit var image : ImageView
    private lateinit var fullName : TextView
    private lateinit var email: TextView

    private lateinit var btnFragSkills: Button
    private lateinit var btnFragHobbies: Button
    private lateinit var btnFragLanguage: Button

    private lateinit var infoBundle : Bundle
    lateinit var fragmentTransaction: FragmentTransaction
    lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutme)

        val toolbar: Toolbar =findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar=supportActionBar
        actionBar?.hide()
        actionBar?.show()

        infoBundle = intent.extras!!


        image = findViewById(R.id.imageView2User)
        fullName = findViewById(R.id.textViewFullName)
        email = findViewById(R.id.textView2Email)

        //val byteArray = infoBundle!!.getByteArray("image")
        //val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        //val image = findViewById<View>(R.id.imageView1) as ImageView
        //image.setImageBitmap(bmp)

        fullName.setText(infoBundle.get("fullName").toString())
        email.setText(infoBundle.get("email").toString())



        btnFragSkills = findViewById(R.id.buttonFragSkills)
        btnFragHobbies = findViewById(R.id.buttonFragHobbies)
        btnFragLanguage = findViewById(R.id.buttonFragLanguage)

        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()
        val myFragment = SkillsFragment()

        val bundle = Bundle()

        bundle.putString("android",infoBundle.get("android").toString())
        bundle.putString("ios",infoBundle.get("ios").toString())
        bundle.putString("flutter",infoBundle.get("flutter").toString())

        myFragment.arguments = bundle


        btnFragSkills.setOnClickListener {

            val bundle = Bundle()

            bundle.putString("android",infoBundle.get("android").toString())
            bundle.putString("ios",infoBundle.get("ios").toString())
            bundle.putString("flutter",infoBundle.get("flutter").toString())

            myFragment.arguments = bundle

            //fragmentTransaction.replace(R.id.fragment_container, myFragment).commit()
            changeFragment(myFragment,"")
        }

        btnFragHobbies.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArray("hobbies", infoBundle.get("hobbies") as Array<out String>?)
            val myFragment = HobbiesFragment()
            myFragment.arguments = bundle

            changeFragment(myFragment,"")
            //fragmentTransaction.replace(R.id.fragment_container, myFragment).commit()

        }

        btnFragLanguage.setOnClickListener {
            val bundle = Bundle()

            bundle.putStringArray("language", infoBundle.get("language") as Array<out String>?)
            //var ye = infoBundle.get("language") as Array<out String>?
            // Toast.makeText(this,"::::::::::::///////::::::::::::   : "+ ye?.get(0).toString(), Toast.LENGTH_SHORT).show();

            val myFragment = LanguageFragment()

            myFragment.arguments = bundle
            changeFragment(myFragment,"")
            //fragmentTransaction.replace(R.id.fragment_container, myFragment).commit()
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, myFragment).commit()
    }

    private fun changeFragment(fragment: Fragment, name: String) {
        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(name).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_aboutme->{

                val bundle = Bundle()

                bundle.putString("fullName",infoBundle.get("fullName").toString())
                bundle.putString("age",infoBundle.get("age").toString())
                bundle.putString("email",infoBundle.get("email").toString())
                bundle.putString("gender",infoBundle.get("gender").toString())

                val myFragment = DisplayAboutMeFragment()

                myFragment.arguments = bundle

                myFragment.arguments = bundle


                //changeFragment(DisplayAboutMeFragment(),"")
                //fragmentTransaction.replace(R.id.fragment_container, myFragment).commit()
                changeFragment(myFragment,"")

            }

        }

        return super.onOptionsItemSelected(item)
    }


}