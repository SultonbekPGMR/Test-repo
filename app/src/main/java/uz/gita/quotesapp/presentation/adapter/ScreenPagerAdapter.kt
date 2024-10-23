package uz.gita.quotesapp.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.quotesapp.presentation.screen.bookmark.BookmarkScreen
import uz.gita.quotesapp.presentation.screen.home.HomeScreen
import uz.gita.quotesapp.presentation.screen.search.SearchScreen
import uz.gita.quotesapp.presentation.screen.theme.ThemeScreen

class ScreenPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> HomeScreen()
            1 -> BookmarkScreen()
            2 -> SearchScreen()
            else -> ThemeScreen()
        }


}