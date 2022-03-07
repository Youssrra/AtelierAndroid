package com.example.curriculumvitaev22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var experienceList: MutableList<Experience>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = experienceList[position]

        val companyName = experienceList[position].companyName
        val companyAddress = experienceList[position].companyAddress
        val startDate = experienceList[position].startDate
        val endDate = experienceList[position].endDate

        holder.imageView.setImageResource(experienceList[position].companyImage)
        holder.textViewName.text = companyName
        holder.textViewPays.text = companyAddress
        holder.textViewDated.text = startDate
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return experienceList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = itemView.findViewById(R.id.img)
        val textViewName : TextView = itemView.findViewById(R.id.name)
        val textViewPays : TextView = itemView.findViewById(R.id.Place)

        val textViewDatef : TextView = itemView.findViewById(R.id.datef)
        val textViewDated : TextView = itemView.findViewById(R.id.dated)
        val textViewDescription : TextView = itemView.findViewById(R.id.description)

    }
}