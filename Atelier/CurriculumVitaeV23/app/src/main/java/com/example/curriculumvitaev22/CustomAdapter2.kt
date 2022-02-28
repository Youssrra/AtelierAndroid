package com.example.curriculumvitaev22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter2 (private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item2, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textViewName.text = ItemsViewModel.textn
        holder.textViewPays.text = ItemsViewModel.textp

        holder.textViewDatef.text = ItemsViewModel.textdf
        holder.textViewDated.text = ItemsViewModel.textdd



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img)
        val textViewName : TextView = itemView.findViewById(R.id.name)
        val textViewPays : TextView = itemView.findViewById(R.id.Place)

        val textViewDatef : TextView = itemView.findViewById(R.id.datef)
        val textViewDated : TextView = itemView.findViewById(R.id.dated)


    }

}