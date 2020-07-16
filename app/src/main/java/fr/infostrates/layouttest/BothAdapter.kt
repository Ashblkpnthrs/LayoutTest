package fr.infostrates.layouttest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter class that handles the data set with the {@link RecyclerView.LayoutManager}
 */
internal class BothAdapter : RecyclerView.Adapter<BothViewHolder>() {

    companion object {
        private val BOTH_IMAGE_IDS = intArrayOf(
                R.drawable.cat_1,
                R.drawable.cat_2,
                R.drawable.cat_3,
                R.drawable.cat_4,
                R.drawable.cat_5,
                R.drawable.cat_6,
                R.drawable.cat_7,
                R.drawable.cat_8,
                R.drawable.cat_9,
                R.drawable.cat_10,
                R.drawable.cat_11,
                R.drawable.cat_12,
                R.drawable.cat_13,
                R.drawable.cat_14,
                R.drawable.cat_15,
                R.drawable.cat_16,
                R.drawable.cat_17,
                R.drawable.cat_18,
                R.drawable.cat_19,
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BothViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_cat, parent, false)
        return BothViewHolder(view)
    }

    override fun onBindViewHolder(holder: BothViewHolder, position: Int) {
        val pos = position % BOTH_IMAGE_IDS.size
        holder.bindTo(BOTH_IMAGE_IDS[pos])
    }

    override fun getItemCount() = BOTH_IMAGE_IDS.size * 4
}