package com.cengizhan.vizyonotoboya


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_gider_ekle.*
import kotlin.random.Random

class giderEkle : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gider_ekle)

        var database = FirebaseDatabase.getInstance().reference


        btnGiderEkle.setOnClickListener {
            val giderId = (0..10000).random()

            var giderTürü = spinner.selectedItem.toString()
            var giderAciklama = etAciklama.text.toString()
            var giderUcret = etUcret.text.toString().toInt()
            var giderTarih = "2020/08/08"

            database.child("giderler").child(giderId.toString()).setValue(dataWrite(giderId,giderTürü,giderAciklama,giderUcret,giderTarih))

            val i = Intent(this,giderler::class.java)
            startActivity(i)
            finish()
        }
    }
    override fun onBackPressed() {
        val igider = Intent(this,giderler::class.java)
        startActivity(igider)
        finish()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }
}


