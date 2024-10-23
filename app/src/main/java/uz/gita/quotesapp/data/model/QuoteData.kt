package uz.gita.quotesapp.data.model

data class QuoteData(
    val id: Int,
    val quote: String,
    val authorData: AuthorData,
    val category: String = "",
    var isLiked: Int = 0,
)