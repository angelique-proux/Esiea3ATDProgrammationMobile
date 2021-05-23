package com.example.esiea3atd1.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.api.UniversityResponse

class UniversityAdapter (private var dataSet: List<UniversityResponse>, private var listener: ((String) -> Unit)? = null ) :
        RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.list_university_name)
        val textViewDomain: TextView = view.findViewById(R.id.list_university_domain)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_universites, viewGroup, false)

        return ViewHolder(view)
    }

    fun updateList(list: List<UniversityResponse>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val university : UniversityResponse = dataSet[position]
        viewHolder.textViewName.text = university.name
        viewHolder.textViewDomain.text = university.domains[0]
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(university.web_pages[0])
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}