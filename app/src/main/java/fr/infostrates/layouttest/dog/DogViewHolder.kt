package fr.infostrates.layouttest.dog

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager
import fr.infostrates.layouttest.R

/**
 * ViewHolder that represents a cat image.
 */
internal class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageView: ImageView = itemView.findViewById(R.id.imageview)

    internal fun bindTo(@DrawableRes drawableRes: Int) {
        imageView.setImageResource(drawableRes)
        val lp = imageView.layoutParams
        if (lp is FlexboxLayoutManager.LayoutParams) {
            lp.flexGrow = 1f
        }
    }
}