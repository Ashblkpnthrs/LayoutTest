package fr.infostrates.layouttest.both

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.infostrates.layouttest.R
import fr.infostrates.layouttest.slider.SliderBothActivity

/**
 * Adapter class that handles the data set with the {@link RecyclerView.LayoutManager}
 */
internal class BothAdapter(private var context: Context) : RecyclerView.Adapter<BothViewHolder>() {

    companion object {
        private val BOTH_IMAGE_IDS = intArrayOf(
                R.drawable.dog_1,
                R.drawable.cat_1,
                R.drawable.dog_2,
                R.drawable.cat_2,
                R.drawable.dog_3,
                R.drawable.cat_3,
                R.drawable.dog_4,
                R.drawable.cat_4,
                R.drawable.dog_5,
                R.drawable.cat_5,
                R.drawable.dog_6,
                R.drawable.cat_6,
                R.drawable.dog_7,
                R.drawable.cat_7,
                R.drawable.dog_8,
                R.drawable.cat_8,
                R.drawable.dog_9,
                R.drawable.cat_9,
                R.drawable.dog_10,
                R.drawable.cat_10,
                R.drawable.dog_11,
                R.drawable.cat_11,
                R.drawable.dog_12,
                R.drawable.cat_12,
                R.drawable.dog_13,
                R.drawable.cat_13,
                R.drawable.dog_14,
                R.drawable.cat_14,
                R.drawable.dog_15,
                R.drawable.cat_15,
                R.drawable.dog_16,
                R.drawable.cat_16,
                R.drawable.dog_17,
                R.drawable.cat_17,
                R.drawable.dog_18,
                R.drawable.cat_18,
                R.drawable.cat_19
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BothViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.viewholder_cat, parent, false)
        return BothViewHolder(view)
    }

    override fun onBindViewHolder(holder: BothViewHolder, position: Int) {
        val pos = position % BOTH_IMAGE_IDS.size
        holder.bindTo(BOTH_IMAGE_IDS[pos])
        holder.imageView.setOnClickListener{
            val intent = Intent(context,SliderBothActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = BOTH_IMAGE_IDS.size * 4
}