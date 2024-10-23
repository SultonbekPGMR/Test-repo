package uz.gita.quotesapp.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.quotesapp.presentation.screen.search.author.AuthorScreen
import uz.gita.quotesapp.presentation.screen.search.category.CategoryScreen

class SearchScreenPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> CategoryScreen()
            else -> AuthorScreen()
        }


}