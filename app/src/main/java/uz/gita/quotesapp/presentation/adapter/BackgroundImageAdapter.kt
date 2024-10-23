package uz.gita.quotesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesapp.data.model.BackgroundImageData
import uz.gita.quotesapp.databinding.BackgroundSelectorItemBinding

class BackgroundImageAdapter(
    private val list: List<BackgroundImageData>,
    private var lastIndex :Int,

    private val funCategorySelected: (imageData: BackgroundImageData, isSelected: Boolean) -> Unit
) : Adapter<BackgroundImageAdapter.Holder>() {




    inner class Holder(private val binding: BackgroundSelectorItemBinding) :
        ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val currentPosition = adapterPosition

                if (lastIndex != currentPosition) {
                    if (lastIndex != -1) {
                        list[lastIndex].isSelected = false
                        notifyItemChanged(lastIndex)
                    }
                    list[currentPosition].isSelected = true
                    notifyItemChanged(currentPosition)
                    lastIndex = currentPosition

                    funCategorySelected.invoke(
                        list[currentPosition],
                        true
                    )
                }
            }
        }

        fun onBind(imageData: BackgroundImageData) {
            binding.img.setImageResource(imageData.imageId)

            binding.containerMaskSelected.visibility =
                if (imageData.isSelected) View.VISIBLE else View.INVISIBLE


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            BackgroundSelectorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.onBind(list[position])

}