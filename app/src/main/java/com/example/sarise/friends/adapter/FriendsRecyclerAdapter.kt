package com.example.sarise.friends.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sarise.friends.R
import kotlinx.android.synthetic.main.item_lista_friends.view.*

class FriendsRecyclerAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder>(){

    private val inflater:LayoutInflater = LayoutInflater.from(context)

    private val friends = lista()

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.item_lista_friends, holder, false )
        return ViewHolder(view)
    }

    override fun getItemCount() = friends.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current:String = friends[position]
        holder.nomeFriends.text = current

    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val nomeFriends: TextView = itemView.txtFriendsListName
    }

    //Lista temporáiria com os dados a serem trabalhados
   /* private fun lista(): List<String>{
        return listOf("Arise",
            "Allan",
            "Prof")
    }
    */

    private fun setFriendsList (friendsList: List<Friends>)

}