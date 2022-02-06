package tn.esprit.curriculumvitaee

import android.R.attr
import android.R.attr.button
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.R.attr.button
import android.R.attr.button
import android.widget.SeekBar
import android.widget.Toast
import android.util.Patterns.EMAIL_ADDRESS
import android.content.Intent




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextbtn: Button = findViewById(R.id.buttonNext)
        val resetbtn: Button = findViewById(R.id.buttonReset)

        val fullName : EditText = findViewById(R.id.editTextFullName)
        val age : EditText = findViewById(R.id.editTextAge)
        val email : EditText = findViewById(R.id.editTextEmail)

        val android : SeekBar = findViewById(R.id.seekBarAndroid)
        val ios : SeekBar = findViewById(R.id.seekBarIos)
        val flutter : SeekBar = findViewById(R.id.seekBarFlutter)

        nextbtn.setOnClickListener{
            if (fullName.length() == 0 || age.length() == 0 || email.length() == 0){
                Toast.makeText(this,"check your input ! ",Toast.LENGTH_SHORT).show();
            }
            if(EMAIL_ADDRESS.matcher(email.toString()).matches()){
                Toast.makeText(this,"check your email ! ",Toast.LENGTH_SHORT).show();
            }
            else{
                if (android.progress > 80 && ios.progress < 80 && flutter.progress < 80){
                    Toast.makeText(this,"Vous ete exellent en Android ",Toast.LENGTH_SHORT).show();
                }else if (ios.progress > 80 && android.progress < 80 && flutter.progress < 80){
                    Toast.makeText(this,"Vous ete exellent en IOS ",Toast.LENGTH_SHORT).show();
                }else if (flutter.progress > 80 && android.progress < 80 && ios.progress < 80){
                    Toast.makeText(this,"Vous ete exellent en Flutter ",Toast.LENGTH_SHORT).show();
                }else if (android.progress <= 30 && ios.progress <= 30 && flutter.progress <= 30){
                    Toast.makeText(this,"Vous devez travailler vos skills ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Vous avez de bon skills !",Toast.LENGTH_SHORT).show();
                }
            }
        }

        resetbtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}