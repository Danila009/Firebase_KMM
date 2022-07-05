package com.example.sneakersshop.services.firestore.model

data class SneakerColor(
    val id:String,
    val title:String,
    val idSneaker:String,
    val icons:List<SneakerColorIconItem>,
    val shoeSize:List<SneakerColorShoeSizeItem>
)

data class SneakerColorShoeSizeItem(
    val shoeSizeId:String,
    val price:String
)


data class SneakerColorIconItem(
    val url:String
)