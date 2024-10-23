package uz.gita.quotesapp.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.quotesapp.data.source.dao.AuthorDao
import uz.gita.quotesapp.data.source.dao.QuoteDao
import uz.gita.quotesapp.data.source.entity.AuthorEntity
import uz.gita.quotesapp.data.source.entity.QuoteEntity

@Database(entities = [AuthorEntity::class, QuoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAuthorDao(): AuthorDao
    abstract fun getQuoteDao(): QuoteDao


    companion object {
        lateinit var instance: AppDatabase
            private set

        fun init(context: Context) {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "quote_db")
                    .allowMainThreadQueries()
                    .build()
            }

        }


    }


}