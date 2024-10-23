package uz.gita.quotesapp.utils

import androidx.fragment.app.Fragment
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.data.source.entity.QuoteEntity

fun Fragment.replaceScreen(where: Int, screen: Fragment) {
    parentFragmentManager.beginTransaction().replace(where, screen).commit()
}

fun Fragment.popBack() {
    parentFragmentManager.popBackStack()
}

fun Fragment.replaceScreen(where: Int, screen: Fragment, addToBackStack: Boolean) {
    parentFragmentManager.beginTransaction().replace(where, screen)
        .addToBackStack(screen.toString()).commit()
}

fun List<QuoteEntity>.mapToQuoteData(authors:List<AuthorData>): List<QuoteData> {
    return this.map { quoteEntity ->
        QuoteData(
            id = quoteEntity.id,
            quote = quoteEntity.quote,
            authorData = authors[quoteEntity.authorIndex],
            category = quoteEntity.category,
            isLiked = quoteEntity.isLiked
        )
    }
}

