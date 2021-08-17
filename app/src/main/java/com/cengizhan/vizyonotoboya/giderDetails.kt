package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_gider_details.*
import kotlinx.android.synthetic.main.activity_work_details.*

class giderDetails : AppCompatActivity() {

    var databaseGider = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gider_details)

        val giderTürü = intent.getStringExtra("keygiderTürü")
        val giderAciklama = intent.getStringExtra("keygiderAciklama")
        val giderUcret = intent.getIntExtra("keygiderUcret",0)
        val giderTarih = intent.getStringExtra("keygiderTarih")
        val giderId = intent.getLongExtra("keyGiderId",0)
        val giderControl = intent.getStringExtra("keygiderControl")

        btnGiderTürü.text = ("Gider türü :  "+giderTürü)
        btnGiderAciklama.text = ("Açıklama :  "+giderAciklama)
        btnGiderUc5et.text = ("Gider ücreti :  "+giderUcret.toString()+" TL")
        giderOlusturmaTarihi.text = ("Oluşturulma tarihi :  "+giderTarih)

        btnGiderİptal.setOnClickListener{

            val updateGider = mapOf<String,Boolean>(
                "giderControl" to false
            )

            databaseGider.child("giderler").child(giderId.toString()).updateChildren(updateGider)
            //databaseOde.child("workOdemeler").child(workId.toString()).removeValue()

            val intent = Intent(this,giderler::class.java)
            startActivity(intent)
            finish()

        }
        btnGiderOdemeEkle.setOnClickListener {
            val iodeme = Intent(this, giderOdeme::class.java)
            iodeme.putExtra("keyygiderId", giderId)
            startActivity(iodeme)
            finish()
        }


        var database = FirebaseDatabase.getInstance().getReference("giderOdemeler").child(giderId.toString())

        var getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var toplam = 0
                for (i in snapshot.children) {
                    var odeme = i.child("giderOdemeUcret").getValue()
                    toplam = odeme.toString().toInt() + toplam
                }
                btnGiderOdeme.text = ("Alınan ödeme :  "+toplam.toString()+ " TL")
                var kalan = giderUcret - toplam
                btnGiderKalan.text = ("Kalan ücret  :  "+kalan.toString() + " TL")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)
    }

    override fun onBackPressed() {
        val iworks = Intent(this,giderler::class.java)
        startActivity(iworks)
        finish()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }


}