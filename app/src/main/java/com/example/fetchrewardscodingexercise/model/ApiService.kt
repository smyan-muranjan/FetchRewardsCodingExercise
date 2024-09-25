package com.example.fetchrewardscodingexercise.model

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

fun fetchJsonData(client: HttpClient, onResult: (Map<Int, List<DataItem>>?) -> Unit) {
    runBlocking {
        try {
            val response: HttpResponse = client.get("https://fetch-hiring.s3.amazonaws.com/hiring.json")
            val res: List<DataItem> = response.body()
            val groupedData = res
                .filter { !it.name.isNullOrBlank() }
                .sortedWith(compareBy({ it.listId }, { it.name }))
                .groupBy { it.listId }

            onResult(groupedData)
        } catch (e: Exception) {
            Log.e("DataFetchError", e.localizedMessage ?: "Unknown error")
            onResult(null)
        }
    }
}