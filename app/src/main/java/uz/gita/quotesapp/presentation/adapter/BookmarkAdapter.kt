package uz.gita.quotesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.databinding.ItemBookmarkBinding

class BookmarkAdapter : Adapter<BookmarkAdapter.Holder>() {

    private var list = ArrayList<QuoteData>()

    lateinit var itemClicked: (index: Int, quoteData: QuoteData) -> Unit

    fun getQuoteCount(): Int {
        return list.size
    }

    fun submitList(newList: List<QuoteData>) {

        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()

    }

    inner class Holder(private val binding: ItemBookmarkBinding) : ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {

                itemClicked.invoke(adapterPosition, list[adapterPosition])
            }
        }

        fun onBind(pos: Int) {
            binding.txtQuote.text = list[pos].quote
            binding.txtAuthor.text = list[pos].authorData.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) =
        holder.onBind(position)


}