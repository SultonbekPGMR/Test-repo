package uz.gita.quotesapp.presentation.screen.home

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.data.source.preference.SharedPreferences
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.databinding.HomeScreenBinding
import uz.gita.quotesapp.presentation.adapter.ItemPagerAdapter
import uz.gita.quotesapp.presentation.animation.MoveAnimation
import uz.gita.quotesapp.presentation.screen.search.author.AuthorInfoScreen
import uz.gita.quotesapp.utils.AppConstants.DURATION
import uz.gita.quotesapp.utils.popBack
import uz.gita.quotesapp.utils.replaceScreen


class HomeScreen : Fragment(R.layout.home_screen), HomeContract.View {
    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        return if (enter) {
            MoveAnimation.create(MoveAnimation.UP, true, DURATION)
        } else {
            MoveAnimation.create(MoveAnimation.DOWN, false, DURATION)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        binding.img.setImageResource(SharedPreferences.getBackgroundImage())
        if (SharedPreferences.isFontChanged) {
            context?.let {
                txtFont = it.resources.getFont(SharedPreferences.getFont())
                presenter = HomePresenter(this, index, txtFont)
                SharedPreferences.isFontChanged = false
            }
        }
        presenter.onResume()


    }

    private var _binding: HomeScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var itemPagerAdapter: ItemPagerAdapter
    private lateinit var presenter: HomeContract.Presenter
    private var clipboard: ClipboardManager? = null
    private lateinit var txtFont: Typeface
    private var index: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = HomeScreenBinding.bind(view)

        clipboard =
            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        itemPagerAdapter = ItemPagerAdapter()
        binding.pager.adapter = itemPagerAdapter

        index = arguments?.getInt("index", 0) ?: 0
        val fromCategory = arguments?.getBoolean("category", false) ?: false
        txtFont = requireContext().resources.getFont(SharedPreferences.getFont())

        val fromBookmark = arguments?.getBoolean("bookmark", false) ?: false
        if (fromBookmark) {
            index = 777

        }

        if (fromCategory) {
            binding.btnBack.visibility = View.VISIBLE
            binding.btnBack.setOnClickListener { popBack() }
        }


        addListeners()

        presenter = HomePresenter(this, index, txtFont)
        if (index == 777){
            binding.btnBack.visibility = View.VISIBLE
            binding.btnBack.setOnClickListener { popBack() }
            binding.pager.postDelayed(Runnable {
                binding.pager.setCurrentItem(arguments?.getInt("index", 0) ?: 0, false )
            }, 100)


        }



    }

    private fun addListeners() {
        itemPagerAdapter.btnCopyClicked = { presenter.btnCopyClicked(it) }

        itemPagerAdapter.btnShareClicked = { presenter.btnShareClicked(it) }

        itemPagerAdapter.btnAuthorClicked = { presenter.btnAuthorClicked(it) }

        itemPagerAdapter.btnBookmarkClicked = { pos, newData ->
            presenter.btnBookmarkClicked(newData)
            itemPagerAdapter.notifyItemChanged(pos)
        }

    }

    override fun submitList(list: ArrayList<QuoteData>, font: Typeface) {
        itemPagerAdapter.submitList(list, font)

    }

    override fun copyDataToClipBoard(data: String) {
        clipboard?.setPrimaryClip(ClipData.newPlainText("Quote", data))
    }

    override fun openShareIntent(data: String) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")

        intent.putExtra(Intent.EXTRA_TEXT, data)
        startActivity(Intent.createChooser(intent, getString(R.string.share_using)))
    }

    val screen = AuthorInfoScreen()
    override fun openAuthorInfoScreen(authorData: AuthorData) {
        val bundle = Bundle()
        bundle.putSerializable("author", authorData)
        screen.arguments = bundle
        replaceScreen(R.id.home_screen, screen, true)
    }

}