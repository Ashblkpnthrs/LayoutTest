package fr.infostrates.layouttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*

class RecyclerActivity : AppCompatActivity() {


    private var arrayListName: ArrayList<String> = ArrayList()
    private var arrayListSubName: ArrayList<String> = ArrayList()
    private var arrayListCity: ArrayList<String> = ArrayList()
    private var arrayListPhoto : ArrayList<Int> = ArrayList()

    private var adapter: FlexboxAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        initArray()
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH
        recyclerView.layoutManager = layoutManager
        adapter = FlexboxAdapter(this, arrayListName,arrayListSubName,arrayListCity,arrayListPhoto)
        recyclerView.adapter = adapter
    }

    private fun initArray() {
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListName.add("John")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListSubName.add("Snow")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListCity.add("Winterfell")
        arrayListPhoto.add(R.drawable.dog_1)
        arrayListPhoto.add(R.drawable.dog_2)
        arrayListPhoto.add(R.drawable.dog_3)
        arrayListPhoto.add(R.drawable.dog_4)
        arrayListPhoto.add(R.drawable.dog_5)
        arrayListPhoto.add(R.drawable.dog_6)
        arrayListPhoto.add(R.drawable.dog_7)
        arrayListPhoto.add(R.drawable.dog_8)
        arrayListPhoto.add(R.drawable.dog_9)
        arrayListPhoto.add(R.drawable.dog_10)
        arrayListPhoto.add(R.drawable.cat_1)
        arrayListPhoto.add(R.drawable.cat_2)
        arrayListPhoto.add(R.drawable.cat_3)
        arrayListPhoto.add(R.drawable.cat_4)
        arrayListPhoto.add(R.drawable.cat_5)
        arrayListPhoto.add(R.drawable.cat_6)
        arrayListPhoto.add(R.drawable.cat_7)
        arrayListPhoto.add(R.drawable.cat_8)
        arrayListPhoto.add(R.drawable.cat_9)
        arrayListPhoto.add(R.drawable.cat_10)

    }
}