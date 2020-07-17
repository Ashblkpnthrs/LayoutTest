package fr.infostrates.layouttest.slider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import fr.infostrates.layouttest.R

class SliderDogActivity : AppCompatActivity() {

    var images:Array<Int> = arrayOf(
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
    var adapter:PagerAdapter = SliderAdapter(this, images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slider_layout)
        val viewPager : ViewPager = findViewById(R.id.viewpager)

        viewPager.adapter = adapter

    }
}