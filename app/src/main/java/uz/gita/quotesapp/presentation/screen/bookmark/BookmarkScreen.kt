package uz.gita.quotesapp.presentation.screen.bookmark

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.BookmarkScreenBinding
import uz.gita.quotesapp.presentation.adapter.BookmarkAdapter
import uz.gita.quotesapp.presentation.screen.home.HomeScreen
import uz.gita.quotesapp.utils.replaceScreen

class BookmarkScreen : Fragment(R.layout.bookmark_screen) {

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var _binding: BookmarkScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BookmarkAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = BookmarkScreenBinding.bind(view)
        adapter = BookmarkAdapter()

        adapter.itemClicked = { index, quoteData ->
            val bundle = Bundle()
            bundle.putBoolean("bookmark", true)
            bundle.putInt("index", index)
            val screen = HomeScreen()
            screen.arguments = bundle
            replaceScreen(R.id.bookmark_screen, screen, true)

        }

        requireActivity().supportFragmentManager.addOnBackStackChangedListener {
            val fm = requireActivity().supportFragmentManager
            fm.let {
                if (it.backStackEntryCount == 0) {
                    adapter.submitList(AppRepository.getBookMarkedQuotes())

                }
            }
        }
        binding.rv.adapter = adapter

        adapter.submitList(AppRepository.getBookMarkedQuotes())
        binding.txtNoBookmark.visibility =
            if (adapter.getQuoteCount() > 0) View.INVISIBLE else View.VISIBLE


    }

    // comment 

    override fun onResume() {
        super.onResume()
        adapter.submitList(AppRepository.getBookMarkedQuotes())
        binding.txtNoBookmark.visibility =
            if (adapter.getQuoteCount() > 0) View.INVISIBLE else View.VISIBLE
    }


}