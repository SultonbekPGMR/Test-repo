package uz.gita.quotesapp.data.source.repository

import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.model.BackgroundImageData
import uz.gita.quotesapp.data.model.CategoryData
import uz.gita.quotesapp.data.model.FontData
import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.data.source.AppDatabase
import uz.gita.quotesapp.data.source.dao.AuthorDao
import uz.gita.quotesapp.data.source.dao.QuoteDao
import uz.gita.quotesapp.data.source.entity.QuoteEntity
import uz.gita.quotesapp.data.source.preference.SharedPreferences
import uz.gita.quotesapp.utils.mapToQuoteData

object AppRepository {
    var categoryList: ArrayList<CategoryData> = ArrayList()
        private set
    var authorList: ArrayList<AuthorData> = ArrayList()
        private set

    private var backgroundImageList: ArrayList<BackgroundImageData> = ArrayList()
    private var fontList: ArrayList<FontData> = ArrayList()

    private lateinit var quoteDao: QuoteDao
    private lateinit var authorDao: AuthorDao

    fun init() {
        quoteDao = AppDatabase.instance.getQuoteDao()
        authorDao = AppDatabase.instance.getAuthorDao()
        initCategoryList()
        initImages()
        initFonts()
        initAuthors()


    }

    fun getList(pos: Int): List<QuoteData> {
        val categories = listOf(
            "Life", "Confidence", "Motivational", "Wisdom",
            "Friendship", "Happiness", "Success", "Perseverance", "Courage"
        )

        return when (pos) {
            0 -> quoteDao.getRandomQuotesBySize(100).mapToQuoteData(authorList)
            in 1..categories.size -> quoteDao.getQuotesByCategory(categories[pos - 1]).mapToQuoteData(authorList)
            777 -> quoteDao.getBookmarkedQuotes().mapToQuoteData(authorList)
            else -> emptyList() // Returns an empty list for invalid positions
        }
    }


    private fun initFonts() {
        fontList.add(FontData(R.font.space_grotesk_regular))
        fontList.add(FontData(R.font.font_2))
        fontList.add(FontData(R.font.font_3))
        fontList.add(FontData(R.font.font_4))
        fontList.add(FontData(R.font.font_5))
        fontList.add(FontData(R.font.font_6))
        fontList.add(FontData(R.font.lato_bold))
        fontList.add(FontData(R.font.font_8))
        fontList.add(FontData(R.font.font_9))
        fontList.add(FontData(R.font.font_10))
        fontList.add(FontData(R.font.font_12))
        fontList.add(FontData(R.font.font_13))
    }

    private fun initImages() {
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_1))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_2))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_3))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_4))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_5))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_6))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_7))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_8))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_9))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_10))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_11))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_12))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_13))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_14))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_15))
        backgroundImageList.add(BackgroundImageData(R.drawable.wall_16))
    }

    private fun initCategoryList() {
        categoryList.add(CategoryData("Life", R.drawable.cat_life, 0))
        categoryList.add(CategoryData("Confidence", R.drawable.cat_confidence, 1))
        categoryList.add(CategoryData("Motivational", R.drawable.cat_motivation, 2))
        categoryList.add(CategoryData("Wisdom", R.drawable.cat_wisdom, 3))
        categoryList.add(CategoryData("Friendship", R.drawable.cat_friendship, 4))
        categoryList.add(CategoryData("Happiness", R.drawable.cat_happiness, 5))
        categoryList.add(CategoryData("Success", R.drawable.cat_success, 6))
        categoryList.add(CategoryData("Perseverance", R.drawable.cat_never_give_up, 7))
        categoryList.add(CategoryData("Courage", R.drawable.cat_courage, 8))


    }

    private fun initAuthors() {
        authorDao.getAllAuthors().map {
            authorList.add(AuthorData(it.index, it.fullName, it.imageId, it.detailedInfo))
        }

    }



    fun getBookMarkedQuotes(): List<QuoteData> {
        return quoteDao.getBookmarkedQuotes().mapToQuoteData(authorList)

    }

    fun updateQuoteData(newData: QuoteData) {
        quoteDao.updateQuote(
            QuoteEntity(
                newData.id,
                newData.quote,
                newData.category,
                newData.isLiked,
                newData.authorData.index
            )
        )
    }

    fun getBackgroundImageList(): List<BackgroundImageData> {
        val savedImageId = SharedPreferences.getBackgroundImage()

        for (i in 0 until backgroundImageList.size) {
            if (backgroundImageList[i].imageId == savedImageId) backgroundImageList[i].isSelected =
                true

        }
        return backgroundImageList
    }

    fun getFontList(): List<FontData> {
        val savedFontId = SharedPreferences.getFont()

        for (i in 0 until fontList.size) {
            if (fontList[i].fontId == savedFontId) fontList[i].isSelected =
                true

        }
        return fontList
    }


}


