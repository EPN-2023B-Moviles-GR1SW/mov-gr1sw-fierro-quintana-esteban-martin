package com.example.deber_03.models

import java.sql.Time
import java.time.LocalTime

data class PostItemModel(
    val iconUrl: String,
    val name: String,
    val time: LocalTime,
    val imgUrl: String
) {
}