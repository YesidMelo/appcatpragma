package com.pruebatecnica.appcatspragma.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pruebatecnica.appcatspragma.R
import com.pruebatecnica.appcatspragma.models.Cat

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

        }
    }
}