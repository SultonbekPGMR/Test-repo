package uz.gita.quotesapp.presentation.screen.search.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.CategoryScreenBinding
import uz.gita.quotesapp.presentation.adapter.CategoryAdapter
import uz.gita.quotesapp.presentation.screen.home.HomeScreen
import uz.gita.quotesapp.utils.replaceScreen

class CategoryScreen : Fragment(R.layout.category_screen) {

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private var _binding: CategoryScreenBinding? = null
    private val binding get() = _binding!!


    private lateinit var rvAdapter: CategoryAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CategoryScreenBinding.bind(view)

        rvAdapter = CategoryAdapter(AppRepository.categoryList) {
            val screen = HomeScreen()
            val bundle = Bundle()
            bundle.putInt("index", it.index)
            bundle.putBoolean("category", true)
            screen.arguments = bundle

            replaceScreen(R.id.search_screen, screen, true)
        }

        binding.rv.adapter = rvAdapter


    }


}