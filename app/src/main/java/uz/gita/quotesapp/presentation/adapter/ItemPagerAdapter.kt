package uz.gita.quotesapp.presentation.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.databinding.PagerItemBinding

class ItemPagerAdapter : Adapter<ItemPagerAdapter.ItemHolder>() {
    private var list: ArrayList<QuoteData> = ArrayList()

    var btnCopyClicked: ((quoteData: QuoteData) -> Unit)? = null
    var btnShareClicked: ((quoteData: QuoteData) -> Unit)? = null
    var btnAuthorClicked: ((quoteData: QuoteData) -> Unit)? = null
    var btnBookmarkClicked: ((position: Int, newData: QuoteData) -> Unit)? = null

    private lateinit var txtFont: Typeface


    fun submitList(list: List<QuoteData>, txtFont: Typeface) {
        this.txtFont = txtFont
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ItemHolder(private val binding: PagerItemBinding) : ViewHolder(binding.root) {

        init {
            binding.btnCopy.setOnClickListener { btnCopyClicked?.invoke(list[adapterPosition]) }

            binding.btnShare.setOnClickListener { btnShareClicked?.invoke(list[adapterPosition]) }

            binding.txtAuthor.setOnClickListener { btnAuthorClicked?.invoke(list[adapterPosition]) }

            binding.btnBookmark.setOnClickListener {
                list[adapterPosition].isLiked = list[adapterPosition].isLiked.xor(1)
                btnBookmarkClicked?.invoke(adapterPosition, list[adapterPosition])
            }

        }

        fun onBind(position: Int) {

            list[position].let {
                binding.txtQuote.text = it.quote
                binding.txtAuthor.text = it.authorData.name
                binding.txtQuote.typeface = txtFont


                binding.btnBookmark.setImageResource(
                    if (it.isLiked == 1) R.drawable.baseline_bookmark_24
                    else R.drawable.baseline_bookmark_border_24)

            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            PagerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(position)
    }

}