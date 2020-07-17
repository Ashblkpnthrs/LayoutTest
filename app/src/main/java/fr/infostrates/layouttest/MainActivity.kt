package fr.infostrates.layouttest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import fr.infostrates.layouttest.both.BothAdapter
import fr.infostrates.layouttest.cat.CatAdapter
import fr.infostrates.layouttest.dog.DogAdapter
import fr.infostrates.layouttest.maze.LabyrintheActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonRecycler : Button = findViewById(R.id.button)
        val buttonMaze : Button = findViewById(R.id.mazeButton)
        val switchView: SuperSwitchView = findViewById(R.id.superswitch)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerview)

        val flexboxLayoutManager = FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }

        recyclerView.apply {
            layoutManager = flexboxLayoutManager
            adapter = DogAdapter(context)
        }

        buttonRecycler.setOnClickListener {
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }
        buttonMaze.setOnClickListener{
            val intent = Intent(this, LabyrintheActivity::class.java)
            startActivity(intent)
        }

        switchView.setCallback(object : SuperSwitchView.ISelectionCallback {
            override fun onNewSelected(oldIndex: Int, newIndex: Int) {
                when (newIndex) {
                    0 -> {
                        recyclerView.apply {
                            layoutManager = flexboxLayoutManager
                            adapter = DogAdapter(context)
                        }
                    }
                    1 -> {
                        recyclerView.apply {
                            layoutManager = flexboxLayoutManager
                            adapter = CatAdapter(context)
                        }
                    }
                    2 -> {
                        recyclerView.apply {
                            layoutManager = flexboxLayoutManager
                            adapter = BothAdapter(context)
                        }
                    }
                }
            }
        })
    }
}