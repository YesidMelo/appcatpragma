package com.pruebatecnica.appcatspragma.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pruebatecnica.appcatspragma.R
import com.pruebatecnica.appcatspragma.data.ApiConstants
import com.pruebatecnica.appcatspragma.models.Cat
import com.squareup.picasso.Picasso

class ListCatsAdapter (
    val listCats : List<Cat>
) : RecyclerView.Adapter<ListCatsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_cats, parent, false)
        view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        return Holder(view = view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.fill(cat = listCats[position])
    }

    override fun getItemCount(): Int = listCats.size

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view) {
        fun fill(cat: Cat) {
            view.findViewById<TextView>(R.id.textView_nameBreed).text = cat.breedName
            view.findViewById<TextView>(R.id.textView_countryOrigin).text = cat.origin
            view.findViewById<TextView>(R.id.textView_intelligence).text = cat.intelligence

            Picasso.get()
                .load("${ApiConstants.BaseImages}${cat.imageUrl}.jpg")
                .into(view.findViewById<ImageView>(R.id.imageView_photo))
        }
    }
}