package uz.gita.quotesapp.presentation.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.databinding.MainScreenBinding
import uz.gita.quotesapp.presentation.adapter.ScreenPagerAdapter

class MainScreen : Fragment(R.layout.main_screen) {

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private var _binding: MainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = MainScreenBinding.bind(view)

        binding.viewPager.isUserInputEnabled = false

        binding.viewPager.adapter = ScreenPagerAdapter(requireActivity())

        binding.bottomNav.setOnItemSelectedListener {
            val pos = when (it.itemId) {
                R.id.bottom_nav_theme -> 3
                R.id.bottom_nav_search -> 2
                R.id.bottom_nav_bookmark -> 1
                else -> 0

            }
            binding.viewPager.currentItem = pos

            return@setOnItemSelectedListener true
        }

    }


}