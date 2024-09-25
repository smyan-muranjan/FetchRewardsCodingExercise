package com.example.fetchrewardscodingexercise.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.viewmodel.DataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataView(
    modifier: Modifier = Modifier,
    dataViewModel: DataViewModel = viewModel()
) {
    val data by dataViewModel.data.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text= stringResource(id = R.string.app_name),
                    modifier = Modifier.padding(top=30.dp),
                    color = colorResource(id = R.color.app_purple)
                ) }
            )
        }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            if (data == null) {
                Text(text = "Fetching data...", style = MaterialTheme.typography.bodyLarge)
            } else {
                DataListView(data)
            }
        }
    }
}
