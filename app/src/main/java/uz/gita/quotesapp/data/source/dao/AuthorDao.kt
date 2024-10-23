package uz.gita.quotesapp.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.source.entity.AuthorEntity


@Dao
interface AuthorDao {

    @Query("SELECT * FROM AuthorEntity")
    fun getAllAuthors(): List<AuthorEntity>

    @Query("SELECT * FROM authorentity WHERE `index` =:index ")
    fun getAuthorByIndex(index: Int): AuthorEntity

    @Insert
    fun insertAuthor(authorEntity: AuthorEntity)

}