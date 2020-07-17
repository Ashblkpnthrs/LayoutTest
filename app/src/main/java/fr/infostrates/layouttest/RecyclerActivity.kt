package fr.infostrates.layouttest

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*

class RecyclerActivity : AppCompatActivity(){

    private var arrayListName: ArrayList<String> = ArrayList()
    private var arrayListSubName: ArrayList<String> = ArrayList()
    private var arrayListCity: ArrayList<String> = ArrayList()
    private var arrayListPhoto : ArrayList<Int> = ArrayList()
    private var arrayListDrawable : ArrayList<Drawable> = ArrayList()
    private lateinit var photoPick: ImageView
    private lateinit var photoText: TextView

    private var adapter: FlexboxAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val itemButton : Button = findViewById(R.id.addButton)
        val pickButton : Button = findViewById(R.id.buttonpick)
        val subName : EditText = findViewById(R.id.subNameText)
        val name : EditText = findViewById(R.id.nameText)
        val city : EditText = findViewById(R.id.cityText)
        val photoPick : ImageView = findViewById(R.id.imageViewGallery)
        val layoutManager = FlexboxLayoutManager(this)
        adapter = FlexboxAdapter(this,arrayListName,arrayListSubName,arrayListCity,arrayListPhoto,arrayListDrawable)

        pickButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    pickImageFromGallery();
                }
            }
            else{
                pickImageFromGallery();
            }
        }

        itemButton.setOnClickListener {
            when {
                name.text.isEmpty() -> {
                    Toast.makeText(this,"Name cannot be empty !",Toast.LENGTH_LONG).show()
                }
                subName.text.isEmpty() -> {
                    Toast.makeText(this,"SubName cannot be empty !",Toast.LENGTH_LONG).show()
                }
                city.text.isEmpty() -> {
                    Toast.makeText(this,"City cannot be empty !",Toast.LENGTH_LONG).show()
                }
//                !photoPick.drawable.isVisible -> {
//                    Toast.makeText(this,"You must select a photo !",Toast.LENGTH_LONG).show()
//                }
                else -> {
                    arrayListName.add(name.text.toString())
                    arrayListSubName.add(subName.text.toString())
                    arrayListCity.add(city.text.toString())
                    //arrayListDrawable.add(photoPick.drawable)
                }
            }
            arrayListPhoto.add(R.drawable.dog_1)
            adapter?.notifyItemInserted(arrayListName.size -1)
        }

        initArray()

        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery()
                }
                else{
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            photoPick = findViewById(R.id.imageViewGallery)
            photoText = findViewById(R.id.photoText)
            photoText.visibility = View.VISIBLE
            photoPick.visibility = View.VISIBLE
            photoPick.setImageURI(data?.data)
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
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

    companion object {
        private val IMAGE_PICK_CODE = 1000;
        private val PERMISSION_CODE = 1001;
    }
}