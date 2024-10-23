package uz.gita.quotesapp.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.gita.quotesapp.data.source.entity.QuoteEntity

@Dao
interface QuoteDao {

    @Query("SELECT * FROM QuoteEntity LIMIT :size")
    fun getRandomQuotesBySize(size: Int): List<QuoteEntity>

    @Query("SELECT * FROM QuoteEntity WHERE category=:selectedCategory ")
    fun getQuotesByCategory(selectedCategory: String): List<QuoteEntity>

    @Query("SELECT * FROM QuoteEntity WHERE isLiked = 1")
    fun getBookmarkedQuotes():List<QuoteEntity>

    @Update
    fun updateQuote(quoteEntity: QuoteEntity)

    @Insert
    fun insertQuote(quoteEntity: QuoteEntity)


}