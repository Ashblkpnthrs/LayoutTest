package fr.infostrates.layouttest.slider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import fr.infostrates.layouttest.R

class SliderAdapter(var context: Context, private var images: Array<Int>) : PagerAdapter() {

    lateinit var inflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as ConstraintLayout

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image:ImageView
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.slider_image_item, container, false)
        image = view.findViewById(R.id.slider_image)
        image.setBackgroundResource(images[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}