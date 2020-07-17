package fr.infostrates.layouttest

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class FlexboxAdapter(private var context: Context, arrayListName: ArrayList<String>, arrayListSubName: ArrayList<String>, arrayListCity: ArrayList<String>, arrayListPhoto: ArrayList<Int> /*, arrayListDrawable: ArrayList<Drawable>*/) : RecyclerView.Adapter<FlexboxAdapter.ViewHolder?>() {

    private var name: ArrayList<String> = ArrayList()
    private var subName: ArrayList<String> = ArrayList()
    private var city: ArrayList<String> = ArrayList()
    private var photo: ArrayList<Int> = ArrayList()
    //private var photoGallery : ArrayList<Drawable> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = name[position]
        holder.subName.text = subName[position]
        holder.city.text = city[position]
//        if(photoGallery.isNotEmpty()) {
//            holder.photo.setImageDrawable(photoGallery[position])
//        }
        holder.photo.setImageResource(photo[position])
        holder.layout.setOnClickListener {
            val intent = Intent(context,PetDetailActivity::class.java)
            intent.putExtra("Name",name[position])
            intent.putExtra("City",city[position])
            intent.putExtra("SubName",subName[position])
            intent.putExtra("Photo", photo[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return name.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.tvName)
        var subName: TextView = itemView.findViewById(R.id.tvSubname)
        var city: TextView = itemView.findViewById(R.id.tvCity)
        var photo : ImageView = itemView.findViewById(R.id.ivPhoto)
        var layout : ConstraintLayout = itemView.findViewById(R.id.layout)
    }

    init {
        this.name = arrayListName
        this.city = arrayListCity
        this.subName = arrayListSubName
        this.photo = arrayListPhoto
        //this.photoGallery = arrayListDrawable
    }
}