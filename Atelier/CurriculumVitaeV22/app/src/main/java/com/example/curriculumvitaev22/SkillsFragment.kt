package com.example.curriculumvitaev22

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast

class SkillsFragment : Fragment() {

    lateinit var android : SeekBar
    lateinit var ios : SeekBar
    lateinit var flutter : SeekBar


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_skills, container, false)

        android = view.findViewById<View>(R.id.seekBarAndroid) as SeekBar
        ios = view.findViewById<View>(R.id.seekBarIOS)  as SeekBar
        flutter = view.findViewById<View>(R.id.seekBarflutter)  as SeekBar

        val bundle = arguments

        //Log.d("myTag", bundle!!.getString("android").toString())

        val and = Integer.parseInt(bundle!!.getString("android"))
        val io = Integer.parseInt(bundle!!.getString("ios"))
        val flu = Integer.parseInt(bundle!!.getString("flutter"))

        android.setProgress(and)
        ios.setProgress(io)
        flutter.setProgress(flu)

        return view

    }
}