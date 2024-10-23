package uz.gita.quotesapp.data.source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val index: Int,
    val fullName: String,
    val imageId: Int,
    val detailedInfo: String,
)