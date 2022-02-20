package com.example.curriculumvitaev2

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val fullName : EditText = findViewById(R.id.edit_textFullName)
    val age : EditText = findViewById(R.id.edit_textAge)
    val email : EditText = findViewById(R.id.edit_textEmail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar =  supportActionBar
        actionBar!!.title = "Create your resume"


        val male : RadioButton = findViewById(R.id.radioButtonMale)
        val female : RadioButton = findViewById(R.id.radioButtonFemale)
        var gender : String
        if(male.isChecked){
            gender = "Male"
        }else{
            gender = "Female"}
        val btnNext : Button = findViewById(R.id.buttonNext)

        btnNext.setOnClickListener {
                if (fieldVerification()) {
                    val intent = Intent(this, SkillsActivity::class.java).apply {
                        putExtra("fullName",fullName.getText())
                        putExtra("age",age.text)
                        putExtra("email",email.text)
                        putExtra("gender",gender)
                    }
                    startActivity(intent)
                    //Toast.makeText(this,"GOOD TO GO ! ",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"Something went wrong please try again ",Toast.LENGTH_SHORT).show();
                }
        }
    }

    private fun fieldVerification(): Boolean {

        var fullNameError : TextView  = findViewById(R.id.textViewfullNameError)
        var ageError : TextView = findViewById(R.id.textViewAgeError)
        var emailError : TextView = findViewById(R.id.textViewEmailError)


        if (fullName.length() == 0) {
            fullName.setError("Must not be empty !")
            fullNameError.setText("Must not be empty !")
            return false;
        }
        if (email.length() == 0) {
            email.setError("Must not be empty !");
            emailError.setText("Must not be empty !")
            return false;
        }
        if (age.length() == 0) {
            age.setError("Must not be empty !");
            ageError.setText("Must not be empty !")
            return false;
        }
        if (EMAIL_ADDRESS.matcher(email.toString()).matches()) {
            email.setError("Check your email !");
            emailError.setText("Check your email !")
            return false;
        }
        return true;
    }


}