package fr.infostrates.layouttest.slider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import fr.infostrates.layouttest.R

class SliderCatActivity : AppCompatActivity() {

    var images:Array<Int> = arrayOf(
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
            R.drawable.cat_19
    )
    var adapter:PagerAdapter = SliderAdapter(this, images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slider_layout)
        val viewPager : ViewPager = findViewById(R.id.viewpager)

        viewPager.adapter = adapter
    }
}