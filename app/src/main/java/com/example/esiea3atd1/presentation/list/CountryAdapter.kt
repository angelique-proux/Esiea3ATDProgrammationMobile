package com.example.esiea3atd1.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.api.CountryResponse

class CountryAdapter (private var dataSet: List<CountryResponse>, var listener: ((String) -> Unit)? = null ) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.list_item_name)
            imageView = view.findViewById(R.id.list_item_pic)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    fun updateList(list: List<CountryResponse>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val country : CountryResponse = dataSet[position]
        viewHolder.textView.text = country.name
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(country.name)
        }

        Glide
            .with(viewHolder.itemView.context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position + 1}.png")
            .centerCrop()
            .into(viewHolder.imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}