package com.example.fetchrewardscodingexercise.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.model.DataItem

@Composable
fun DataCard(item: DataItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.app_light_purple)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "ID: ${item.id}",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.app_grey)
            )
            Text(
                text = "Name: ${item.name}",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.app_grey)
            )
        }
    }
}