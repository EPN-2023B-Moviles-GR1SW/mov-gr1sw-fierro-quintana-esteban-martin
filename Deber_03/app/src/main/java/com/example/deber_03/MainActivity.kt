package com.example.deber_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_msg)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            MsgItemModel("https://randomuser.me/api/portraits/thumb/men/10.jpg","Juan","Hola mundo"),
            MsgItemModel("https://randomuser.me/api/portraits/thumb/women/11.jpg","Maria","Hola mundo"),
            MsgItemModel("https://randomuser.me/api/portraits/thumb/men/12.jpg","Caza","Hola mundo"),

        )

        val adapter = MsgListAdapter(itemList)
        recyclerView.adapter = adapter
    }
}