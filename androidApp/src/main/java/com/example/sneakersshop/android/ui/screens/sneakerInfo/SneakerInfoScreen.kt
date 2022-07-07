package com.example.sneakersshop.android.ui.screens.sneakerInfo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sneakersshop.android.commpon.extensions.launchWhenStarted
import com.example.sneakersshop.android.ui.theme.primaryBackground
import com.example.sneakersshop.android.ui.theme.primaryText
import com.example.sneakersshop.android.ui.theme.secondaryBackground
import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.viewModels.sneakerInfoViewModel.SneakerInfoViewModel
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "FlowOperatorInvokedInComposition")
@Composable
fun SneakerInfoScreen(
    viewModel: SneakerInfoViewModel = getViewModel(),
    navController: NavController,
    idSneaker: String,
) {
    var sneakerDTO : SneakerDTO? by rememberSaveable { mutableStateOf(null) }

    viewModel.getSneakerById(idSneaker)
    viewModel.responseSneaker.onEach {
        sneakerDTO = it
    }.launchWhenStarted()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = primaryBackground,
                actions = {
                    Card(
                        modifier = Modifier,
                        backgroundColor = secondaryBackground,
                        shape = AbsoluteRoundedCornerShape(15.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.padding(20.dp),
                            onClick = { navController.navigateUp() }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null,
                                tint = primaryText
                            )
                        }
                    }
                },
                title = {
                    Text(
                        text = "PRODUCT",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W900,
                        color = primaryText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = primaryText
                        )
                    }
                }
            )
        }, content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = primaryBackground
            ) {
                LazyColumn(content = {
                    item {
                        Column {
                            Text(
                                text = sneakerDTO?.title ?: "",
                                color = primaryText,
                                fontWeight = FontWeight.W900,
                                fontSize = 32.sp
                            )
                        }
                    }
                })
            }
        }
    )
}