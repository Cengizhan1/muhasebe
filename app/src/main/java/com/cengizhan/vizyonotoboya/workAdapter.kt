package com.cengizhan.vizyonotoboya

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.item_view.view.*
import kotlinx.android.synthetic.main.itemgider.view.*

class workAdapter(private val workList: ArrayList<sonWorks>) : RecyclerView.Adapter<workAdapter.workHolder>()  {

    private lateinit var context : Context

    val database = FirebaseDatabase.getInstance().getReference("works")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):workAdapter.workHolder {
        context = parent.context
        return workAdapter.workHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }
    override fun onBindViewHolder(holder: workHolder, position: Int) {
        val currentWork =workList[position]


        val wAd = holder.itemView.txtAlıcıad
        val wModel = holder.itemView.txtModell
        val wTeslim = holder.itemView.txtTeslim
        val wUcret = holder.itemView.txtUcret

        wAd.text = currentWork.alıcıAd
        wModel.text = currentWork.arabaModel
        wTeslim.text = currentWork.tahminiTeslim.toString()
        wUcret.text = (currentWork.ucret.toString()+" TL")
        val wId = currentWork.workId
        val wTelefon = currentWork.telefon.toString()
        val wYapılanis = currentWork.yapılanis.toString()
        val uc = currentWork.ucret

         holder.itemView.setOnClickListener() {


             val intent= Intent(context,workDetails::class.java)
             intent.putExtra("keyTelefon",wTelefon)
             intent.putExtra("keyId",wId)
             intent.putExtra("keyYapılaniş",wYapılanis)
             intent.putExtra("keyAd",wAd.text)
             intent.putExtra("keyModel",wModel.text)
             intent.putExtra("keyTeslim",wTeslim.text)
             intent.putExtra("keyUcret",uc)

             context.startActivity(intent)


         }
    }



    override fun getItemCount(): Int = workList.size

    class workHolder (itemView: View) : RecyclerView.ViewHolder(itemView)



}