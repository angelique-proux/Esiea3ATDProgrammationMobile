package com.example.esiea3atd1.presentation.list

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R


class RegionAdapter (private var dataSet: List<String>, private var listener: ((String) -> Unit)? = null ) :
    RecyclerView.Adapter<RegionAdapter.ViewHolder>() {

    private lateinit var resources: Resources

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.list_region_name)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_regions, viewGroup, false)

        return ViewHolder(view)
    }

    fun updateList(list: List<String>, res: Resources){
        dataSet = list
        notifyDataSetChanged()
        resources = res
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val region : String = dataSet[position]
        // TODO the name must be change with the language of the application
        when (position) {
            0 -> {
                viewHolder.textView.text = resources.getString(R.string.Africa)
            }
            1 -> {
                viewHolder.textView.text = resources.getString(R.string.Americas)
            }
            2 -> {
                viewHolder.textView.text = resources.getString(R.string.Asia)
            }
            3 -> {
                viewHolder.textView.text = resources.getString(R.string.Europe)
            }
            4 -> {
                viewHolder.textView.text = resources.getString(R.string.Oceania)
            }
            else -> {
                viewHolder.textView.text = resources.getString(R.string.Polar)
            }
        }
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(region)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
