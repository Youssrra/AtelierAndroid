package com.example.curriculumvitaev22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView

class DisplayAboutMeFragment : Fragment() {

    lateinit var fullName : TextView
    lateinit var age : TextView
    lateinit var email : TextView
    lateinit var gender : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_display_about_me, container, false)

        fullName = view.findViewById<View>(R.id.textViewNameDisplay) as TextView
        age = view.findViewById<View>(R.id.textViewAgeDisplay)  as TextView
        email = view.findViewById<View>(R.id.textViewEmailDisplay)  as TextView
        gender = view.findViewById<View>(R.id.textViewGenderDisplay)  as TextView

        val bundle = arguments


        fullName.text = "Hello ! My name is "+ bundle!!.getString("fullName")
        age.text = "I have "+bundle!!.getString("age")+" years old"
        gender.text = "And I am a "+bundle!!.getString("gender")
        email.text = bundle!!.getString("email")


        return view
    }
}

