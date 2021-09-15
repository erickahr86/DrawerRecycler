package com.example.drawerrecycler.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawerrecycler.R
import com.example.drawerrecycler.inflate
import com.example.drawerrecycler.listeners.RecyclerFlightListener
import com.example.drawerrecycler.loadByResource
import com.example.drawerrecycler.models.Flight

class FlightAdapter(private val flights: List<Flight>, private val listener: RecyclerFlightListener)
    : RecyclerView.Adapter<FlightAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder( parent.inflate( R.layout.recycler_flight ) )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind( flights[position], listener )

    override fun getItemCount() = flights.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun bind( flight: Flight, listener: RecyclerFlightListener) = with(itemView){

            findViewById<TextView>  ( R.id.textViewCity ).text = flight.city
            findViewById<ImageView> ( R.id.imageViewBg  ).loadByResource( flight.imgResourceId )

            setOnClickListener { listener.onClick( flight, adapterPosition ) }

            findViewById<ImageButton>( R.id.buttonDelete ).setOnClickListener { listener.onDelete( flight, adapterPosition) }

        }

    }


}