package com.example.drawerrecycler

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.drawerrecycler.databinding.ActivityMainBinding
import com.example.drawerrecycler.fragments.ArrivalsFragment
import com.example.drawerrecycler.fragments.DeparturesFragment
import com.example.drawerrecycler.fragments.HomeFragment

import com.example.mylibrary.ToolbarActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbarToLoad(binding.toolbar as Toolbar)

        setNavDrawer()
        setUserHeaderInformation()

        if (savedInstanceState == null)
        {
            fragmentTransaction( HomeFragment() )
            binding.navView.menu.getItem( 0 ).isChecked = true
        }
    }

    private fun setNavDrawer() {
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar as Toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        toggle.isDrawerIndicatorEnabled = true

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
    }

    private fun fragmentTransaction(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun loadFragmentById(id: Int)
    {
        when( id )
        {
            R.id.nav_home       -> fragmentTransaction( HomeFragment()       )
            R.id.nav_departures -> fragmentTransaction( DeparturesFragment() )
            R.id.nav_arrivals   -> fragmentTransaction( ArrivalsFragment()   )
        }
    }

    private fun showMessageNavItemSelectedById(id: Int)
    {
        when( id )
        {
            R.id.nav_profile  -> toast("Profile"  )
            R.id.nav_settings -> toast("Settings" )
        }
    }

    private fun setUserHeaderInformation()
    {
        val name = binding.navView.getHeaderView(0).findViewById<TextView>(R.id.textViewName )
        val mail = binding.navView.getHeaderView(0).findViewById<TextView>(R.id.textViewMail )

        name?.let { name.text = getString(R.string.user_name) }
        mail?.let { mail.text = getString(R.string.user_mail) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        loadFragmentById              ( item.itemId )
        showMessageNavItemSelectedById( item.itemId )

        binding.drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onBackPressed() {
        if ( binding.drawerLayout.isDrawerOpen(GravityCompat.START) )
        {
            binding.drawerLayout.closeDrawer( GravityCompat.START )
        } else {
            super.onBackPressed()
        }
    }




}