package uz.gita.quotesapp.presentation.screen.home

import android.graphics.Typeface
import uz.gita.quotesapp.data.model.QuoteData

class HomePresenter(
    private val view: HomeContract.View,
    private val listIndex: Int,
    private val font: Typeface,
) :
    HomeContract.Presenter {
    private val model = HomeModel()

    init {
        view.submitList(model.getListByIndex(listIndex) as ArrayList, font = font)
    }

    override fun btnCopyClicked(quoteData: QuoteData) {
        view.copyDataToClipBoard("Quote: " + quoteData.quote + "\n\n" + "Author" + quoteData.authorData.name)
    }

    override fun btnShareClicked(quoteData: QuoteData) {
        view.openShareIntent("Quote: " + quoteData.quote + "\n\n" + "Author" + quoteData.authorData.name)
    }

    override fun btnAuthorClicked(quoteData: QuoteData) {
        view.openAuthorInfoScreen(quoteData.authorData)
    }

    override fun btnBookmarkClicked(newData: QuoteData) {
        model.updateQuoteData(newData)
    }

    override fun onResume() {
        view.submitList(model.getListByIndex(listIndex) as ArrayList, font = font)

    }

}