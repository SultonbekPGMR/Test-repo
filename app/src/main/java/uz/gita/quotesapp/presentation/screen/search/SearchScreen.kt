package uz.gita.quotesapp.presentation.screen.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import uz.gita.quotesapp.R
import uz.gita.quotesapp.databinding.SearchScreenBinding
import uz.gita.quotesapp.presentation.adapter.SearchScreenPagerAdapter

class SearchScreen : Fragment(R.layout.search_screen) {

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: SearchScreenBinding? = null
    private val binding get() = _binding!!


    private lateinit var pagerAdapter: SearchScreenPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = SearchScreenBinding.bind(view)


        pagerAdapter = SearchScreenPagerAdapter(requireActivity())
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if (position == 0) "Categories"
            else "Authors"
        }.attach()


    }


}