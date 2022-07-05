package com.example.sneakersshop.android.ui.screens.sneakers

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.sneakersshop.android.commpon.extensions.launchWhenStarted
import com.example.sneakersshop.services.firestore.model.Sneaker
import com.example.sneakersshop.viewModels.sneakersViewModel.SneakersViewModel
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel

@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun SneakersScreen(
    viewModel:SneakersViewModel = getViewModel()
) {

    var sneakers by rememberSaveable { mutableStateOf(emptyList<Sneaker>()) }

    viewModel.responseSneakers.onEach {
        sneakers = it
    }.launchWhenStarted()

    LazyColumn(content = {
        items(sneakers){ item ->
            Column {
                Text(text = item.title)

                Text(text = item.id)
            }
        }
    })
}