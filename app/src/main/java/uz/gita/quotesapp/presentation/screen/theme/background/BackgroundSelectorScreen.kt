package uz.gita.quotesapp.presentation.screen.theme.background

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.BackgroundImageData
import uz.gita.quotesapp.data.source.preference.SharedPreferences
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.BackgroundSelectorScreenBinding
import uz.gita.quotesapp.presentation.adapter.BackgroundImageAdapter

class BackgroundSelectorScreen : Fragment(R.layout.background_selector_screen) {

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: BackgroundSelectorScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvAdapter: BackgroundImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = BackgroundSelectorScreenBinding.bind(view)

        val images = AppRepository.getBackgroundImageList()

        rvAdapter = BackgroundImageAdapter(images, getLastIndex(images)) {imageData, isSelected ->
            if (isSelected) {
                SharedPreferences.saveBackgroundImage(imageData)
                SharedPreferences.isBackgroundChanged = true
            }
        }

        binding.rv.adapter = rvAdapter


    }

    private fun getLastIndex(images: List<BackgroundImageData>): Int {
        for (i in images.indices){
            if (images[i].isSelected) return i
        }
        return -1
    }


}