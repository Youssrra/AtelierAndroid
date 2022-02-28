package com.example.curriculumvitaev22

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream



class MainActivity : AppCompatActivity() {

    lateinit var fullName : EditText
    lateinit var age : EditText
    lateinit var email : EditText
    lateinit var image : ImageView
    lateinit var male : RadioButton
    lateinit var female : RadioButton
    lateinit var btnNext : Button

    var REQUEST_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fullName  = findViewById(R.id.edit_textFullName)
        age = findViewById(R.id.edit_textAge)
        email = findViewById(R.id.edit_textEmail)
        image = findViewById(R.id.imageViewUser)
        male = findViewById(R.id.radioButtonMale)
        female = findViewById(R.id.radioButtonFemale)
        btnNext= findViewById(R.id.buttonNext)



        image.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)

        }

        btnNext.setOnClickListener {
            if (fieldVerification()) {
                var gender : String
                if(male.isChecked){
                    gender = "Male"
                }else{
                    gender = "Female"
                }

                val intent = Intent(this, SkillsActivity::class.java).apply {
                    putExtra("fullName",fullName.text)
                    putExtra("age",age.text)
                    putExtra("email",email.text)
                    putExtra("gender",gender)

                    //val bitmap = (image.drawable as BitmapDrawable).bitmap
                    //val stream = ByteArrayOutputStream()
                    //bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
                    //var imageData = stream.toByteArray()

                    //putExtra("image" ,image as ByteArray)
                }
                startActivity(intent)
                //Toast.makeText(this,"GOOD TO GO ! ",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Something went wrong please try again ", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            image.setImageURI(data?.data) // handle chosen image
        }
    }

    private fun fieldVerification(): Boolean {
        val fullName : EditText = findViewById(R.id.edit_textFullName)
        val age : EditText = findViewById(R.id.edit_textAge)
        val email : EditText = findViewById(R.id.edit_textEmail)

        var fullNameError : TextView = findViewById(R.id.textViewfullNameError)
        var ageError : TextView = findViewById(R.id.textViewAgeError)
        var emailError : TextView = findViewById(R.id.textViewEmailError)


        if (fullName.length() == 0) {
            fullName.error = "Must not be empty !"
            fullNameError.text = "Must not be empty !"
            return false
        }
        if (email.length() == 0) {
            email.error = "Must not be empty !"
            emailError.text = "Must not be empty !"
            return false
        }
        if (age.length() == 0) {
            age.error = "Must not be empty !"
            ageError.text = "Must not be empty !"
            return false
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
            email.error = "Check your email !"
            emailError.text = "Check your email !"
            return false
        }
        if (image == null){
            Toast.makeText(this,"Please select an image ! ", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}