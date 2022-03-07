package com.example.curriculumvitaev22

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class SkillsActivity : AppCompatActivity()  {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_skills)

            val android : SeekBar = findViewById(R.id.seekBarAndroid)
            val ios : SeekBar = findViewById(R.id.seekBarIOS)
            val flutter : SeekBar = findViewById(R.id.seekBarflutter)

            val arabic : CheckBox = findViewById(R.id.checkboxArabic)
            val french : CheckBox = findViewById(R.id.checkboxFrench)
            val english : CheckBox = findViewById(R.id.checkboxEnglish)

            val music : CheckBox = findViewById(R.id.checkboxMusic)
            val sport : CheckBox = findViewById(R.id.checkboxSport)
            val games : CheckBox = findViewById(R.id.checkboxGames)

            val btnSubmit : Button = findViewById(R.id.buttonSubmit)
            val checkBoxRememberMe : CheckBox = findViewById(R.id.checkBoxRememberMe)

            lateinit var mSharedPref: SharedPreferences

            val bundle: Bundle = intent.extras!!
            val fullname = bundle.get("fullName")
            val age = bundle.get("age")
            val email = bundle.get("email")
            val language: MutableList<String> = ArrayList()
            //var language : Array<String> = arrayOf()
            var hobbies : MutableList<String> = ArrayList()
            mSharedPref = getSharedPreferences("skills_data", MODE_PRIVATE);
            if (mSharedPref.getBoolean("is_remembered", false)){

                val mainIntent = Intent(this, AboutMeActivity::class.java)
                startActivity(mainIntent)
            }
            btnSubmit.setOnClickListener {

                    val intent = Intent(this, AboutMeActivity::class.java).apply {
                    putExtra("fullName",fullname.toString())
                    putExtra("age",bundle.get("age").toString())
                    putExtra("email", bundle.get("email").toString())
                    putExtra("gender", bundle.get("gender").toString())
                        putExtra("image", bundle.get("image").toString())


                    putExtra("android",android.progress.toString())
                    putExtra("ios",ios.progress.toString())
                    putExtra("flutter", flutter.progress.toString())

                    if(arabic.isChecked) {
                        language.add("Arabic")


                    }
                    if(french.isChecked) {
                        language.add("French")

                    }
                    if(english.isChecked) {
                        language.add("English")

                    }


                    putExtra("language",language.toTypedArray())

                    if(music.isChecked) {
                        hobbies.add("Music")
                    }
                    if(sport.isChecked) {
                        hobbies.add("Sport")
                    }
                    if(games.isChecked) {
                        hobbies.add("Games")
                    }

                    putExtra("hobbies",hobbies.toTypedArray())

                }


                if (checkBoxRememberMe.isChecked){
                    mSharedPref.edit().apply{
                        putBoolean("is_remembered", true)

                        putString("fullName",fullname.toString())
                        putString("age",bundle.get("age").toString())
                        putString("email", bundle.get("email").toString())
                        putString("gender", bundle.get("gender").toString())
                        putString("image", bundle.get("image").toString())
                        putString("android",android.progress.toString())
                        putString("ios",ios.progress.toString())
                        putString("flutter", flutter.progress.toString())
                        putBoolean("arabic",arabic.isChecked)
                        putBoolean("french",french.isChecked)
                        putBoolean("english",english.isChecked)
                        putBoolean("music",music.isChecked)
                        putBoolean("games",games.isChecked)
                        putBoolean("sport",sport.isChecked)

                    }.apply()

                }
                else{
                    mSharedPref.edit().clear().apply()
                }

                startActivity(intent)
            }


        }
}