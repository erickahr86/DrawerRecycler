package com.example.mylibrary

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mylibrary.interfaces.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        toolbar?.let { setSupportActionBar(_toolbar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }

}