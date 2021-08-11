package com.cengizhan.vizyonotoboya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import kotlinx.android.synthetic.main.itemgider.view.*

class workAdapter(private val workList: ArrayList<sonWorks>) : RecyclerView.Adapter<workAdapter.workHolder>()  {

    private lateinit var context : Context

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
        wUcret.text = currentWork.ucret.toString()

        /* holder.itemView.setOnClickListener() {


             val it_mDetails= Intent(context,DetailsActivity::class.java)
             it_mDetails.putExtra("it_movieName",movieName)
             it_mDetails.putExtra("it_movieRating",movieRating.toString())
             it_mDetails.putExtra("it_movieDetail",movieDetails)
             it_mDetails.putExtra("it_movieImage",movieImage)
             context.startActivity(it_mDetails)

         }*/
    }



    override fun getItemCount(): Int = workList.size

    class workHolder (itemView: View) : RecyclerView.ViewHolder(itemView)



}