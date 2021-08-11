package com.cengizhan.vizyonotoboya

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemgider.view.*

class giderAdapter(private val giderList: ArrayList<sonGiderler>) : RecyclerView.Adapter<giderAdapter.giderHolder>() {

    private lateinit var context : Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): giderHolder {
        context = parent.context
        return giderHolder(LayoutInflater.from(context).inflate(R.layout.itemgider,parent,false))
    }



    override fun onBindViewHolder(holder: giderHolder, position: Int) {
        val currentGider =giderList[position]


        val gTürü = holder.itemView.txtGiderTürü
        val gAciklama = holder.itemView.txtGiderAciklama
        val gTarih = holder.itemView.txtGiderTarih
        val gUcret = holder.itemView.txtGiderUcret

        gTürü.text = currentGider.giderTürü
        gAciklama.text = currentGider.giderAciklama
        gTarih.text = currentGider.giderTarih
        gUcret.text = currentGider.giderUcret.toString()

       /* holder.itemView.setOnClickListener() {


            val it_mDetails= Intent(context,DetailsActivity::class.java)
            it_mDetails.putExtra("it_movieName",movieName)
            it_mDetails.putExtra("it_movieRating",movieRating.toString())
            it_mDetails.putExtra("it_movieDetail",movieDetails)
            it_mDetails.putExtra("it_movieImage",movieImage)
            context.startActivity(it_mDetails)

        }*/    }

    override fun getItemCount(): Int = giderList.size

    class giderHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}