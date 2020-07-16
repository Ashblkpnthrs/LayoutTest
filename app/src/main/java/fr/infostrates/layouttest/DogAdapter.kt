package fr.infostrates.layouttest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class DogAdapter : RecyclerView.Adapter<DogViewHolder>() {

    companion object {
        private val DOG_IMAGE_IDS = intArrayOf(
                R.drawable.dog_1,
                R.drawable.dog_2,
                R.drawable.dog_3,
                R.drawable.dog_4,
                R.drawable.dog_5,
                R.drawable.dog_6,
                R.drawable.dog_7,
                R.drawable.dog_8,
                R.drawable.dog_9,
                R.drawable.dog_10,
                R.drawable.dog_11,
                R.drawable.dog_12,
                R.drawable.dog_13,
                R.drawable.dog_14,
                R.drawable.dog_15,
                R.drawable.dog_16,
                R.drawable.dog_17,
                R.drawable.dog_18
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val pos = position % DOG_IMAGE_IDS.size
        holder.bindTo(DOG_IMAGE_IDS[pos])
    }

    override fun getItemCount() = DOG_IMAGE_IDS.size * 4
}