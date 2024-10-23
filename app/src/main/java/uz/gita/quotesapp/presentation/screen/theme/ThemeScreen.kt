package uz.gita.quotesapp.presentation.screen.theme

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import uz.gita.quotesapp.R
import uz.gita.quotesapp.databinding.SearchScreenBinding
import uz.gita.quotesapp.databinding.ThemeScreenBinding
import uz.gita.quotesapp.presentation.adapter.SearchScreenPagerAdapter
import uz.gita.quotesapp.presentation.adapter.ThemeScreenPagerAdapter

class ThemeScreen:Fragment(R.layout.theme_screen) {


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: ThemeScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var pagerAdapter: ThemeScreenPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ThemeScreenBinding.bind(view)

        pagerAdapter = ThemeScreenPagerAdapter(requireActivity())
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if (position == 0) "Backgrounds"
            else "Fonts"
        }.attach()

    }


}