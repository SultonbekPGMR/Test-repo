package uz.gita.quotesapp.data.model

import java.io.Serializable

data class AuthorData(
    val index: Int,
    val name: String,
    val imageId:Int,
    val detailedInfo: String,
):Serializable
