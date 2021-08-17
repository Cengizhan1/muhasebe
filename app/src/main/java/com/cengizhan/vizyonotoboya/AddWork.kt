package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_add_work.*
import kotlinx.android.synthetic.main.activity_ozet.*
import java.text.SimpleDateFormat
import java.util.*
var countWork:Long =0
class AddWork : AppCompatActivity() {

    var dCount = FirebaseDatabase.getInstance().getReference()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        var databaseWork = FirebaseDatabase.getInstance().reference

        dCount.child("works").get().addOnSuccessListener{
            countWork = it.childrenCount
        }


        btnWorkKaydet.setOnClickListener {


            var workId        = countWork + 1
            var control       = true
            var alıcıAd       = txtModell.text.toString()
            var telefon       = etTextPhone.text.toString()
            var tahminiTeslim = etTahminTeslim.text.toString()
            var arabaModel    = etEkleModel.text.toString()
            var yapılanis     = etYapılanIs.text.toString()
            var ucret         = etUcretWork.text.toString().toInt()

            val form = SimpleDateFormat("dd-MM-yyyy HH:mm")
            val tarih = Date()
            val workTarih = form.format(tarih).toString()

            databaseWork.child("works").child(workId.toString()).setValue(workDataWrite(workId,control,alıcıAd,telefon,
                tahminiTeslim,arabaModel,yapılanis,ucret,workTarih))


            val intent = Intent(this,works::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        val iworks = Intent(this,works::class.java)
        startActivity(iworks)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }

}