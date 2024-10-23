package uz.gita.quotesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.databinding.AuthorItemBinding

class AuthorAdapter(
    private val list: List<AuthorData>,
    private val itemClicked: (authorData: AuthorData) -> Unit,
) : Adapter<AuthorAdapter.Holder>() {

    inner class Holder(private val binding: AuthorItemBinding) : ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClicked.invoke(list[adapterPosition])
            }

        }

        fun onBind(pos: Int) {
            binding.txtName.text = list[pos].name
            binding.img.setImageResource(list[pos].imageId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            AuthorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.onBind(position)

}