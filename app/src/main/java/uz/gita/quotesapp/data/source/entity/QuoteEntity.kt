package uz.gita.quotesapp.data.source.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val quote: String,
    val category: String,
    val isLiked: Int,
    val authorIndex: Int,
)