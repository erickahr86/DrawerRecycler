package com.example.drawerrecycler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawerrecycler.R
import com.example.drawerrecycler.adapters.FlightAdapter
import com.example.drawerrecycler.databinding.FragmentDeparturesBinding
import com.example.drawerrecycler.listeners.RecyclerFlightListener
import com.example.drawerrecycler.models.Flight
import com.example.drawerrecycler.toast


class DeparturesFragment : Fragment() {

    private var _binding: FragmentDeparturesBinding? = null
    private val binding get() = _binding!!

    private val list: ArrayList<Flight> by lazy { getFlights() }

    private lateinit var recycler : RecyclerView
    private lateinit var adapter      : FlightAdapter

    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.setTitle( R.string.departures )

        _binding = FragmentDeparturesBinding.inflate(inflater, container, false)
        val rootView = binding.root

        recycler = binding.recyclerView
        setRecyclerView()

        return rootView
    }

    private fun setRecyclerView()
    {
        recycler.setHasFixedSize(true)

        recycler.itemAnimator  = DefaultItemAnimator()
        recycler.layoutManager = layoutManager

        adapter = (FlightAdapter(list, object: RecyclerFlightListener{
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let's go to ${ flight.city }")
            }

            override fun onDelete(flight: Flight, position: Int) {
                list.remove( flight )
                adapter.notifyItemRemoved( position )
                activity?.toast("${flight.city} has been removed!")
            }
        }))

        recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getFlights(): ArrayList<Flight>{
        return  object : ArrayList<Flight>() {
            init {
                add( Flight(1, "Ciudad de México", R.drawable.cdmx     ) )
                add( Flight(2, "Buenos Aires"    , R.drawable.bsas     ) )
                add( Flight(3, "Santiago"        , R.drawable.santiago ) )
            }
        }
    }

}