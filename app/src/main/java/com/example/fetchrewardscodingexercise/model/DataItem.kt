package com.example.fetchrewardscodingexercise.model

import kotlinx.serialization.Serializable

@Serializable
data class DataItem(
    val id: Int,
    val listId: Int,
    val name: String?
)
