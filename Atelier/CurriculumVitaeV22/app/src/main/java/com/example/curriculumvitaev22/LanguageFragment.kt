package com.example.curriculumvitaev22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar

class LanguageFragment : Fragment() {

    lateinit var arabic : CheckBox
    lateinit var english : CheckBox
    lateinit var french : CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_language, container, false)

        arabic = view.findViewById<View>(R.id.checkboxArabic2) as CheckBox
        english = view.findViewById<View>(R.id.checkboxEnglish2)  as CheckBox
        french = view.findViewById<View>(R.id.checkboxFrench2)  as CheckBox

        val bundle = arguments


        val lang = bundle!!.getStringArray("language")
        var size = lang!!.size

        if( size == 3){
            arabic.setChecked(true)
            english.setChecked(true)
            french.setChecked(true)
        }else{
            println("::::::::::::::::::: ////////////////////////::::::: "+size)
            for (i in lang) {

                if(i == "Arabic"){
                    arabic.setChecked(true)
                }
                if(i == "English"){
                    english.setChecked(true)

                }
                if(i == "French"){
                    french.setChecked(true)

                }
            }
        }

        return view
    }
}