package com.example.sarise.friends.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.sarise.friends.R
import com.example.sarise.friends.adapter.FriendsRecyclerAdapter
import com.example.sarise.friends.db.Friends
import com.example.sarise.friends.viewmodel.FriendsViewModel
import kotlinx.android.synthetic.main.activity_lista_friends.*
import java.util.*

class ListaFriendsActivity : AppCompatActivity() {

    private lateinit var friendsViewModel: FriendsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_friends)

       // val friend = Friends(1, "Arise")
        // val friend2 = Friends(telefone = "9999-9999", nome = "Arise Again", id = 2)


        val recyclerView = rvListaFriends
        val adapter = FriendsRecyclerAdapter(context = this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        friendsViewModel = ViewModelProviders.of(this).get(FriendsViewModel::class.java)

        friendsViewModel.allFriends.observe(this, Observer{friends -> friends?.let{}})
    }

}
