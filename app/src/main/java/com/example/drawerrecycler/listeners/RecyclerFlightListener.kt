package com.example.drawerrecycler.listeners

import com.example.drawerrecycler.models.Flight
import java.text.FieldPosition

interface RecyclerFlightListener {

    fun onClick  ( flight: Flight, position: Int )
    fun onDelete ( flight: Flight, position: Int )


}