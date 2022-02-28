package com.example.curriculumvitaev22

import android.content.Intent
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

            val bundle: Bundle = intent.extras!!
            val fullname = bundle.get("fullName")
            val age = bundle.get("age")
            val email = bundle.get("email")
            val language: MutableList<String> = ArrayList()
            //var language : Array<String> = arrayOf()
            var hobbies : MutableList<String> = ArrayList()

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
                startActivity(intent)
            }


        }
}