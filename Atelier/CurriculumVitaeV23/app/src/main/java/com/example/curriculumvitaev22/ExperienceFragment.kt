package com.example.curriculumvitaev22

import CustomAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExperienceFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_experience, container, false)


        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this.context)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        val dec : String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."

        data.add(ItemsViewModel(R.drawable.ic_logo_amazon, "AMAZON","UNITED STATE", "01/09/2019","TODAY",dec))
        data.add(ItemsViewModel(R.drawable.ic_logo_facebook, "FACEBOOK","FRANCE", "01/09/2018","31/08/2019",dec))
        data.add(ItemsViewModel(R.drawable.ic_logo_microsoft, "MICROSOFT","UNITED KIGDOM", "01/09/2015","31/08/2016",dec))
        data.add(ItemsViewModel(R.drawable.ic_logo_esprit, "ESPRIT","TUNISIA", "01/09/2013","31/08/2015",dec))


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return view

    }


}