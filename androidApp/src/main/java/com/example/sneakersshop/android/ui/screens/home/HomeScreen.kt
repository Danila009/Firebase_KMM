package com.example.sneakersshop.android.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sneakersshop.android.commpon.extensions.launchWhenStarted
import com.example.sneakersshop.android.services.firestore.dto.SneakerBackgroundColorDTO
import com.example.sneakersshop.android.services.firestore.extensions.mapSneakerBackgroundColor
import com.example.sneakersshop.android.ui.theme.primaryBackground
import com.example.sneakersshop.android.ui.theme.primaryText
import com.example.sneakersshop.android.ui.theme.secondaryText
import com.example.sneakersshop.android.ui.view.Image
import com.example.sneakersshop.services.firestore.model.Advertising
import com.example.sneakersshop.viewModels.sneakersViewModel.SneakersViewModel
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel

@SuppressLint("FlowOperatorInvokedInComposition", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel:SneakersViewModel = getViewModel()
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    var sneakers by rememberSaveable { mutableStateOf(emptyList<SneakerBackgroundColorDTO>()) }

    var advertising by rememberSaveable { mutableStateOf(emptyList<Advertising>()) }

    viewModel.responseSneakers.onEach { sneakersDTO ->
        sneakers = sneakersDTO.map { sneaker -> sneaker.mapSneakerBackgroundColor() }
    }.launchWhenStarted()

    viewModel.responseAdvertising.onEach {
        advertising = it
    }.launchWhenStarted()

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = primaryBackground
            ) {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "PRODUCTS",
                        modifier = Modifier.padding(5.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W900,
                        color = primaryText
                    )
                    Row {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(30.dp),
                                tint = primaryText
                            )
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(30.dp),
                                tint = primaryText
                            )
                        }
                    }
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = primaryBackground
        ) {
            LazyColumn(content = {

                item {
                    LazyRow(content = {
                        items(advertising){ item ->
                            Image(
                                url = item.previews,
                                modifier = Modifier
                                    .padding(15.dp)
                                    .width(screenWidth)
                                    .fillMaxHeight()
                            )
                        }
                    })
                }

                items(sneakers){ item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        backgroundColor = item.backgroundColor.color,
                        shape = AbsoluteRoundedCornerShape(20.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                url = item.promo,
                                modifier = Modifier
                                    .size(400.dp, 300.dp)
                                    .padding(5.dp)
                            )

                            Text(
                                text = item.title,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontWeight = FontWeight.W900,
                                fontSize = 14.sp,
                                color = secondaryText
                            )

                            Text(
                                text = item.brand.title,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                fontWeight = FontWeight.W500,
                                fontSize = 12.sp,
                                color = secondaryText
                            )
                        }
                    }
                }
            })
        }
    }
}