package uz.gita.quotesapp.presentation.adapter

import android.graphics.Typeface
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesapp.data.model.FontData
import uz.gita.quotesapp.databinding.FontSelectorItemBinding


class FontSelectorAdapter(
    private val list: List<FontData>,
    private var lastIndex: Int,
    private var imgId: Int,
    private val funFontSelected: (fontData: FontData, isSelected: Boolean) -> Unit,
) : Adapter<FontSelectorAdapter.Holder>() {

    inner class Holder(private val binding: FontSelectorItemBinding) :
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

                    funFontSelected.invoke(
                        list[currentPosition],
                        true
                    )
                }
            }
        }


        @RequiresApi(Build.VERSION_CODES.O)
        fun onBind(fontData: FontData) {
            binding.img.setImageResource(imgId)


            val typeface: Typeface =
                binding.root.context.resources.getFont(list[adapterPosition].fontId)
            binding.txtQuote.typeface = typeface
            binding.containerMaskSelected.visibility =
                if (fontData.isSelected) View.VISIBLE else View.INVISIBLE


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            FontSelectorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.onBind(list[position])

}