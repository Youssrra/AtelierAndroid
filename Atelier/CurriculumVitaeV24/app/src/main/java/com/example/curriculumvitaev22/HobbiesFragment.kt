package com.example.curriculumvitaev22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

class HobbiesFragment : Fragment() {

    lateinit var sport : CheckBox
    lateinit var music : CheckBox
    lateinit var games : CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_hobbies, container, false)

        sport = view.findViewById<View>(R.id.checkboxSport) as CheckBox
        music = view.findViewById<View>(R.id.checkboxMusic)  as CheckBox
        games = view.findViewById<View>(R.id.checkboxGames)  as CheckBox

        val bundle = arguments


        val hob = bundle!!.getStringArray("hobbies")
        var size = hob!!.size

        if( size == 3){
            sport.isChecked = true
            music.isChecked = true
            games.isChecked = true
        }else{
            for (i in hob) {

                if(i == "Sport"){
                    sport.isChecked = true
                }
                if(i == "Music"){
                    music.isChecked = true

                }
                if(i == "Games"){
                    games.isChecked = true

                }
            }
        }

        return view
    }
}