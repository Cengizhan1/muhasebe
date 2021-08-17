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
        gUcret.text = (currentGider.giderUcret.toString()+" TL")

        val giderTürü = currentGider.giderTürü
        val giderAciklama = currentGider.giderAciklama
        val giderUcret = currentGider.giderUcret
        val giderTarih = currentGider.giderTarih
        val giderControl = currentGider.giderControl
        val giderId = currentGider.giderId

        holder.itemView.setOnClickListener() {


            val intent= Intent(context,giderDetails::class.java)
            intent.putExtra("keygiderTürü",giderTürü)
            intent.putExtra("keyGiderId",giderId)
            intent.putExtra("keygiderAciklama",giderAciklama)
            intent.putExtra("keygiderUcret",giderUcret)
            intent.putExtra("keygiderTarih",giderTarih)
            intent.putExtra("giderControl",giderControl)

            context.startActivity(intent)


        }    }

    override fun getItemCount(): Int = giderList.size

    class giderHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}