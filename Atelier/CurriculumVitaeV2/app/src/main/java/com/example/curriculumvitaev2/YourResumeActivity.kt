package com.example.curriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class YourResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_resume)

        val actionBar =  supportActionBar
        actionBar!!.title = "Your Resume"

        val bundle: Bundle = intent.extras!!


        val fullName : TextView = findViewById(R.id.textViewName)
        fullName.setText("Name : "+bundle.get("fullName") as String)

        val email : TextView = findViewById(R.id.textViewEmail)
        email.setText("Email : "+bundle.get("email") as String)

        val age : TextView = findViewById(R.id.textViewAge)
        age.setText("Age : "+bundle.get("age") as String)

        val gender :  TextView = findViewById(R.id.textViewGender)
        gender.setText("Gender : "+bundle.get("gender") as String)

        val androidSkills : TextView = findViewById(R.id.textViewAndroidSkills)
        androidSkills.setText("Android Skills : "+bundle.get("android") as String)

        val iosSkills: TextView = findViewById(R.id.textViewIosSkills)
        iosSkills.setText("IOS Skills : "+bundle.get("ios") as String)

        val flutterSkills: TextView = findViewById(R.id.textViewflutter)
        flutterSkills.setText("Flutter Skills : "+bundle.get("flutter") as String)

        val language : TextView = findViewById(R.id.textViewLanguage)
        language.setText("Languages : "+bundle.get("language") as String)

        val hobbies : TextView = findViewById(R.id.textViewHobbies)
        hobbies.setText("Hobbies : "+bundle.get("hobbies") as String)

        // putExtra("language",language)
        //val bundle: Bundle = intent.extras!!
        //val fullname = bundle.get("fullName") as String
        //val age = bundle.get("age") as String
        //val email = bundle.get("email") as String

    }
}