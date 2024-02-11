package com.example.deber_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deber_03.models.MsgItemModel
import com.example.deber_03.models.MsgListAdapter
import com.example.deber_03.models.PostItemModel
import com.example.deber_03.models.PostListAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDate
import java.time.LocalTime

class ChannelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel)

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

        val rvPost: RecyclerView = findViewById(R.id.rv_posts)
        rvPost.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            PostItemModel(
                "https://randomuser.me/api/portraits/thumb/men/10.jpg",
                "Juan",
                LocalTime.now(),
                "https://picsum.photos/200"
            ),
            PostItemModel(
                "https://randomuser.me/api/portraits/thumb/men/11.jpg",
                "Simp de Act",
                LocalTime.now(),
                "https://picsum.photos/300/400"
            ),
            PostItemModel(
                "https://randomuser.me/api/portraits/thumb/men/12.jpg",
                "xxxtentationzzz",
                LocalTime.now(),
                "https://picsum.photos/400/500"
            ),
            PostItemModel(
                "https://randomuser.me/api/portraits/thumb/men/13.jpg",
                "errtete",
                LocalTime.now(),
                "https://picsum.photos/200"
            )

        )
        val postAdapter = PostListAdapter(itemList)
        rvPost.adapter = postAdapter
    }
}