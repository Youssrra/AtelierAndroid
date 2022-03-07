import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev22.ItemsViewModel
import com.example.curriculumvitaev22.R

class CustomAdapter2(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter2.ViewHolder2>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item2, parent, false)

        return ViewHolder2(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textViewName.text = ItemsViewModel.textn
        holder.textViewPays.text = ItemsViewModel.textp

        holder.textViewDatef.text = ItemsViewModel.textdf
        holder.textViewDated.text = ItemsViewModel.textdd
        holder.textViewDescription.text = ItemsViewModel.textdesc


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder2(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img)
        val textViewName : TextView = itemView.findViewById(R.id.name)
        val textViewPays : TextView = itemView.findViewById(R.id.Place)


        val textViewDatef : TextView = itemView.findViewById(R.id.datef)
        val textViewDated : TextView = itemView.findViewById(R.id.dated)
        val textViewDescription : TextView = itemView.findViewById(R.id.description)

    }
}