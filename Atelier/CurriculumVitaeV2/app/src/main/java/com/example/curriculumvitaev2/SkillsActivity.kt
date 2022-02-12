package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        val actionBar =  supportActionBar
        actionBar!!.title = "Create your resume"

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
        //val fullname = bundle.get("fullName") as String
        //val age = bundle.get("age") as String
        //val email = bundle.get("email") as String

        var language : Array<String> = arrayOf()
        var hobbies : Array<String> = arrayOf()

        btnSubmit.setOnClickListener {
            val intent = Intent(this, YourResumeActivity::class.java).apply {
                putExtra("fullName",bundle.get("fullName") as String)
                putExtra("age",bundle.get("age") as String)
                putExtra("email", bundle.get("email") as String)
                putExtra("gender", bundle.get("gender") as String)

                putExtra("android",android.progress.toString())
                putExtra("ios",ios.progress.toString())
                putExtra("flutter", flutter.progress.toString())

                if(arabic.isChecked) {
                    language[language.size + 1] = "Arabic"
                }
                if(french.isChecked) {
                    language[language.size + 1] = "French"
                }
                if(english.isChecked) {
                    language[language.size + 1] = "English"
                }

                putExtra("language",language)

                if(music.isChecked) {
                    hobbies[language.size + 1] = "Music"
                }
                if(sport.isChecked) {
                    hobbies[language.size + 1] = "Sport"
                }
                if(games.isChecked) {
                    hobbies[language.size + 1] = "Games"
                }

                putExtra("hobbies",hobbies)

            }
            startActivity(intent)
        }


    }
}