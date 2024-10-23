package uz.gita.quotesapp.presentation.screen.home

import android.graphics.Typeface
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.model.QuoteData

interface HomeContract {


    interface Model {
        fun getListByIndex(index: Int): List<QuoteData>
        fun updateQuoteData(newData: QuoteData)
    }

    interface View {
        fun submitList(list: ArrayList<QuoteData>, font: Typeface)
        fun copyDataToClipBoard(data: String)
        fun openShareIntent(data: String)
        fun openAuthorInfoScreen(authorData: AuthorData)


    }

    interface Presenter {

        fun btnCopyClicked(quoteData: QuoteData)
        fun btnShareClicked(quoteData: QuoteData)
        fun btnAuthorClicked(quoteData: QuoteData)
        fun btnBookmarkClicked(newData: QuoteData)
        fun onResume()
    }


}