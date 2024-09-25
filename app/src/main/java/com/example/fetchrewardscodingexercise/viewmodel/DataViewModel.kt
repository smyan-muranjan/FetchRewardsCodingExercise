package com.example.fetchrewardscodingexercise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardscodingexercise.model.DataItem
import com.example.fetchrewardscodingexercise.model.fetchJsonData
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {
    private val _data = MutableStateFlow<Map<Int, List<DataItem>>?>(null)
    val data: StateFlow<Map<Int, List<DataItem>>?> get() = _data

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            fetchJsonData(client) { result ->
                _data.value = result
            }
        }
    }
}
