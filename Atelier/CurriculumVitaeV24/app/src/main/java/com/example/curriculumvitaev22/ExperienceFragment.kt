package com.example.curriculumvitaev22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExperienceFragment : Fragment() {

    lateinit var dataBase : AppDataBase
    lateinit var recylcerExperience: RecyclerView
    lateinit var recylcerExperienceAdapter: CustomAdapter
    lateinit var experienceList : MutableList<Experience>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_experience, container, false)


        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)


        dataBase = AppDataBase.getDatabase(this.context as AddExperienceActivity)

        experienceList = ArrayList()
        experienceList = dataBase.experienceDao().getAllExperience() as MutableList<Experience>
        recylcerExperienceAdapter = CustomAdapter(experienceList)
        recylcerExperience.adapter = recylcerExperienceAdapter

        //recyclerview.layoutManager = LinearLayoutManager(this.context)

        recylcerExperience.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)

        return view

    }


}