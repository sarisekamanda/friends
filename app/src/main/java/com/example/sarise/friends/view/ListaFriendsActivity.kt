package com.example.sarise.friends.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.sarise.friends.R
import com.example.sarise.friends.adapter.FriendsRecyclerAdapter
import kotlinx.android.synthetic.main.activity_lista_friends.*

class ListaFriendsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_friends)

        val recyclerView = rvListaFriends
        val adapter = FriendsRecyclerAdapter(context = this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

}
