package uz.gita.quotesapp.presentation.screen.home

import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.data.source.repository.AppRepository

class HomeModel : HomeContract.Model {
    override fun getListByIndex(index: Int): List<QuoteData> {
        return AppRepository.getList(index)
    }

    override fun updateQuoteData(newData: QuoteData) {
        AppRepository.updateQuoteData(newData)
    }


}