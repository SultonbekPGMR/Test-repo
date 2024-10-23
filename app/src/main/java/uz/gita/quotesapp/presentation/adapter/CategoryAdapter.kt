package uz.gita.quotesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesapp.data.model.CategoryData
import uz.gita.quotesapp.databinding.CategoryItemBinding

class CategoryAdapter(
    private val list: List<CategoryData>,
    private val itemClicked: (categoryData: CategoryData) -> Unit,
) : Adapter<CategoryAdapter.Holder>() {

    inner class Holder(private val binding: CategoryItemBinding) : ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClicked.invoke(list[adapterPosition])
            }

        }

        fun onBind(pos: Int) {
            binding.txtTitle.text = list[pos].name
            binding.img.setImageResource(list[pos].imageId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.onBind(position)

}