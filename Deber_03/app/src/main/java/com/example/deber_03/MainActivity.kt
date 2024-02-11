package com.example.deber_03

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deber_03.models.IconListAdapter
import com.example.deber_03.models.MsgItemModel
import com.example.deber_03.models.MsgListAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMsg: RecyclerView = findViewById(R.id.rv_msg)
        rvMsg.layoutManager = LinearLayoutManager(this)

        val rvIcon: RecyclerView = findViewById(R.id.rv_icons)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvIcon.layoutManager = layoutManager

        val itemList = listOf(
            MsgItemModel("https://randomuser.me/api/portraits/thumb/men/10.jpg","Juan","Hola mundo"),
            MsgItemModel("https://randomuser.me/api/portraits/thumb/women/11.jpg","Maria","Hola mundo"),
            MsgItemModel("https://randomuser.me/api/portraits/thumb/men/12.jpg","Caza","Hola mundo"),
            MsgItemModel("https://randomuser.me/api/portraits/thumb/women/12.jpg","Ana","Hola q tal"),
            MsgItemModel("https://randomuser.me/api/portraits/thumb/men/13.jpg","Pedro","Hxdxdxd"),

        )

        val iconAdapter = IconListAdapter(itemList)
        val msgAdapter = MsgListAdapter(itemList)
        rvMsg.adapter = msgAdapter
        rvIcon.adapter = iconAdapter


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav1)
        bottomNavigationView.selectedItemId = BottomNavState.selectedItem


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_msg -> {
                    BottomNavState.selectedItem = R.id.nav_msg
                    startActivity(Intent(this, MainActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                R.id.nav_channel -> {
                    BottomNavState.selectedItem = R.id.nav_channel
                    startActivity(Intent(this, ChannelActivity::class.java))
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }


}