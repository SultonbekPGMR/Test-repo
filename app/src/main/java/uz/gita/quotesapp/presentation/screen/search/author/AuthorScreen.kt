package uz.gita.quotesapp.presentation.screen.search.author

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.AuthorScreenBinding
import uz.gita.quotesapp.presentation.adapter.AuthorAdapter
import uz.gita.quotesapp.presentation.animation.MoveAnimation
import uz.gita.quotesapp.utils.AppConstants.DURATION
import uz.gita.quotesapp.utils.replaceScreen

class AuthorScreen : Fragment(R.layout.author_screen) {



    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private var _binding: AuthorScreenBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AuthorScreenBinding.bind(view)

        val screen = AuthorInfoScreen()
        binding.rv.adapter = AuthorAdapter(AppRepository.authorList) {
            val bundle  =Bundle()
            bundle.putSerializable("author", it)
            screen.arguments = bundle
            replaceScreen(R.id.search_screen, screen, true)
        }


    }

}