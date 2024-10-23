package uz.gita.quotesapp.presentation.screen.theme.font

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.FontData
import uz.gita.quotesapp.data.source.preference.SharedPreferences
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.FontSelectorScreenBinding
import uz.gita.quotesapp.presentation.adapter.FontSelectorAdapter

class FontSelectorScreen : Fragment(R.layout.font_selector_screen) {

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: FontSelectorScreenBinding? = null
    private val binding get() = _binding!!


    private lateinit var rvAdapter: FontSelectorAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FontSelectorScreenBinding.bind(view)

        initRv()

    }

    private fun initRv() {
        val fontList = AppRepository.getFontList()
        val image = SharedPreferences.getBackgroundImage()

        rvAdapter =
            FontSelectorAdapter(fontList, getLastIndex(fontList), image) { fontData, isSelected ->
                if (isSelected) {
                    SharedPreferences.saveFont(fontData)
                    SharedPreferences.isFontChanged = true
                }
            }

        binding.rv.adapter = rvAdapter

    }


    private fun getLastIndex(fonts: List<FontData>): Int {
        for (i in fonts.indices) {
            if (fonts[i].isSelected) return i
        }
        return -1
    }


    override fun onResume() {
        super.onResume()
        if (SharedPreferences.isBackgroundChanged) {
            initRv()
            SharedPreferences.isBackgroundChanged = false
        }

    }

}