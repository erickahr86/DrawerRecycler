package com.example.drawerrecycler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drawerrecycler.R


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.setTitle( R.string.home )

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}