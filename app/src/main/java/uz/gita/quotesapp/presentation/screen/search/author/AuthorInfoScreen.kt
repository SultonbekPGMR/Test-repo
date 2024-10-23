package uz.gita.quotesapp.presentation.screen.search.author

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.AuthorInfoScreenBinding
import uz.gita.quotesapp.presentation.animation.MoveAnimation
import uz.gita.quotesapp.utils.AppConstants.DURATION
import uz.gita.quotesapp.utils.popBack

class AuthorInfoScreen : Fragment(R.layout.author_info_screen) {

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        return if (enter) {
            MoveAnimation.create(MoveAnimation.LEFT, true, DURATION)
        } else {
            MoveAnimation.create(MoveAnimation.RIGHT, false, DURATION)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private var _binding: AuthorInfoScreenBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AuthorInfoScreenBinding.bind(view)

        val authorData =
            arguments?.getSerializable("author") as AuthorData? ?: AppRepository.authorList[7]

        init(authorData)

    }

    private fun init(authorData: AuthorData) {
        binding.apply {
            img.setImageResource(authorData.imageId)
            txtName.text = authorData.name
            txtDetails.text = authorData.detailedInfo

            btnBack.setOnClickListener{popBack()}
        }
    }

}