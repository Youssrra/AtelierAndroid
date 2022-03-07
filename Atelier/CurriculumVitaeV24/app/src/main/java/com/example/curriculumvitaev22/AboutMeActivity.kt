package com.example.curriculumvitaev22

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
    private  lateinit var btnMyCareer : Button

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //Important step, we enable button on the left side of the toolbar

        toolbar.navigationIcon = getDrawable(R.drawable.ic_baseline_home_24) //Here we change default navigation button icon


        toolbar.setNavigationOnClickListener {
          funn()
        }
        infoBundle = intent.extras!!


        image = findViewById(R.id.imageView2User)
        fullName = findViewById(R.id.textViewFullName)
        email = findViewById(R.id.textView2Email)

        //val byteArray = infoBundle!!.getByteArray("image")
        //val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        //val image = findViewById<View>(R.id.imageView1) as ImageView
        //image.setImageBitmap(bmp)

        fullName.text = infoBundle.get("fullName").toString()
        email.text = infoBundle.get("email").toString()



        btnFragSkills = findViewById(R.id.buttonFragSkills)
        btnFragHobbies = findViewById(R.id.buttonFragHobbies)
        btnFragLanguage = findViewById(R.id.buttonFragLanguage)
        btnMyCareer = findViewById(R.id.buttonMyCareer)

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

        btnMyCareer.setOnClickListener {
            val intent = Intent(this, MyCareerActivity::class.java)
            startActivity(intent)
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, myFragment).commit()
    }

    private fun funn() {
        Toast.makeText(applicationContext,"this is toast message",Toast.LENGTH_SHORT).show()
        val toast = Toast.makeText(applicationContext, "Hello Javatpoint", Toast.LENGTH_LONG)
        toast.show()
        val myToast = Toast.makeText(applicationContext,"toast message with gravity",Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.LEFT,200,200)
        myToast.show()
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

            R.id.action_logOut->{
                showDialog();
            }


        }

        return super.onOptionsItemSelected(item)
    }

    private fun showDialog(){
        // Late initialize an alert dialog object
        lateinit var dialog:AlertDialog
        // Initialize a new instance of alert dialog builder object
        val builder = AlertDialog.Builder(this)
        // Set a title for alert dialog
        builder.setTitle("Logout")
        // Set a message for alert dialog
        builder.setMessage("Are you sure you want to logout ?")
        // On click listener for dialog buttons
        val dialogClickListener = DialogInterface.OnClickListener{_,which ->
            when(which){
                DialogInterface.BUTTON_POSITIVE -> {
                    getSharedPreferences("skills_data", MODE_PRIVATE).edit().clear().apply()
                   // finish()
                    System.exit(0)
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                    dialog.hide()
                }
            }
        }

        // Set the alert dialog positive/yes button
        builder.setPositiveButton("YES",dialogClickListener)
        // Set the alert dialog negative/no button
        builder.setNegativeButton("NO",dialogClickListener)

        // Initialize the AlertDialog using builder object
        dialog = builder.create()
        // Finally, display the alert dialog
        dialog.show()
    }


}