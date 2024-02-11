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
            MsgItemModel("Elemento 1"),
            MsgItemModel("Elemento 2"),
            MsgItemModel("Elemento 3"),
            // Agrega más elementos segú3 sea necesario
        )

        val adapter = MsgListAdapter(itemList)
        recyclerView.adapter = adapter
    }
}