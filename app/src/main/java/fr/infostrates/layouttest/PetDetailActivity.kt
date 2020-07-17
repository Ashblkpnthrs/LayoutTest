package fr.infostrates.layouttest

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_detail_layout)

        val city : TextView = findViewById(R.id.cityTv)
        val subName : TextView = findViewById(R.id.subNameTv)
        val name : TextView = findViewById(R.id.nameTv)
        val photo : ImageView = findViewById(R.id.imageView)

        val namePet = intent.getStringExtra("Name")
        val subNamePet = intent.getStringExtra("SubName")
        val cityPet = intent.getStringExtra("City")
        val photoPet = intent.getIntExtra("Photo",0)

        city.text = cityPet
        name.text = namePet
        subName.text = subNamePet
        photo.setImageResource(photoPet)
    }
}