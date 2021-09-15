package com.example.drawerrecycler

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()

fun Activity.toast(resourceId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resourceId, duration).show()

fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from( context ).inflate(layoutId, this, false)

fun ImageView.loadByURL(url: String) = Picasso.get().load(url).into(this)

fun ImageView.loadByResource(resourceId: Int ) = Picasso.get().load(resourceId).into(this)

inline fun <reified T : Activity > Activity.gotoActivity(noinline init: Intent.() -> Unit = {})
{
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}