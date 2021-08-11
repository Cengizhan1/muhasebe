package com.cengizhan.vizyonotoboya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_work.*

class AddWork : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        var databaseWork = FirebaseDatabase.getInstance().reference

        btnWorkKaydet.setOnClickListener {
            val id = (0..10000).random()

            var alıcıAd       = txtModell.text.toString()
            var telefon       = etTextPhone.text.toString().toLong()
            var tahminiTeslim = etTahminTeslim.text.toString()
            var arabaModel    = etEkleModel.text.toString()
            var yapılanis     = etYapılanIs.text.toString()
            var ucret         = etUcretWork.text.toString().toInt()

            databaseWork.child("works").child(id.toString()).setValue(workDataWrite(alıcıAd,telefon,tahminiTeslim,arabaModel,yapılanis,ucret))
        }
    }
}