package com.example.esiea3atd1.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esiea3atd1.R

class RegionAdapter (private var dataSet: List<String>, var listener: ((String) -> Unit)? = null ) :
        RecyclerView.Adapter<RegionAdapter.ViewHolder>() {


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

    fun updateList(list: ArrayList<String>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val region : String = dataSet[position]
        viewHolder.textView.text = region
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(region)
        }

        Glide
                .with(viewHolder.itemView.context)
                .load("https://picsum.photos/id/${position + 200}/200/300")
                .centerCrop()
                .into(viewHolder.imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}