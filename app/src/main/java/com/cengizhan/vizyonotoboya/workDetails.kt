package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_work_details.*

class workDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_details)

        //getData()

        var databaseOde = FirebaseDatabase.getInstance().reference


        val workId=intent.getIntExtra("keyId",0)
        val ucret=intent.getIntExtra("keyUcret",0)
        val telefon=intent.getStringExtra("keyTelefon")
        val yapılaniş=intent.getStringExtra("keyYapılaniş")
        val model=intent.getStringExtra("keyModel")
        val ad=intent.getStringExtra("keyAd")
        val tarih=intent.getStringExtra("keyTeslim")



        workDetAd.text = ("Müsteri adı :  "+ad)
        workDetModel.text = ("Araba modeli :  "+model)
        workDetTel.text = ("Telefon :  "+telefon)
        workDetTeslim.text = ("Teslim tarihi :  "+tarih)
        workDetUcret.text = ("Ücret :  "+ucret.toString()+" TL")
        workDetYapılanis.text = ("Yapılan iş :  "+yapılaniş)

        btnDetayOdeme.setOnClickListener {
            val intent = Intent(this, workOdemee::class.java)
            intent.putExtra("keyOde", workId)
            startActivity(intent)
            finish()
        }
        btnDetayIptal.setOnClickListener{
            databaseOde.child("works").child(workId.toString()).removeValue()
            databaseOde.child("workOdemeler").child(workId.toString()).removeValue()

            val intent = Intent(this,works::class.java)
            startActivity(intent)
            finish()

        }
        var database = FirebaseDatabase.getInstance().getReference("workOdemeler").child(workId.toString())

        var getdata = object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var toplam = 0
                    for (i in snapshot.children) {
                        var odeme = i.child("odemeTutar").getValue()
                        toplam = odeme.toString().toInt() + toplam
                    }
                    workDetOdeme.text = (toplam.toString()+ " TL")
                    var kalan = ucret - toplam
                    workDetKalan.text = (kalan.toString() + " TL")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)



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