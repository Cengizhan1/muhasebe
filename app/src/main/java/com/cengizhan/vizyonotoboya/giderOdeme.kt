package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_gider_odeme.*
import java.text.SimpleDateFormat
import java.util.*

class giderOdeme : AppCompatActivity() {
    var countGider:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gider_odeme)
        var gId = intent.getLongExtra("keyygiderId",0)
        var database = FirebaseDatabase.getInstance().reference

        database.child("giderOdemeler").child(gId.toString()).get().addOnSuccessListener{
            countGider = it.childrenCount
        }
        btnGiderOde.setOnClickListener {

            var giderId = gId
            var giderOdemeId = countGider + 1
            var giderOdemeUcret = giderOdenecekTutar.text.toString().toInt()
            val form = SimpleDateFormat("dd-MM-yyyy HH:mm")
            val tarih = Date()
            val giderTarih = form.format(tarih).toString()

            database.child("giderOdemeler").child(giderId.toString()).child(giderOdemeId.toString())
                .setValue(odemeGiderDataWrite(giderId, giderOdemeId, giderOdemeUcret, giderTarih))

            val intent = Intent(this,giderler::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        val iworkDet = Intent(this,giderDetails::class.java)
        startActivity(iworkDet)
        finish()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }
}
class odemeGiderDataWrite {

    var giderId:Long = 0
    var giderOdemeId:Long =0
    var giderOdemeUcret:Int = 0
    var giderTarih:String = ""

    constructor(giderId:Long , giderOdemeId:Long ,  giderOdemeUcret:Int , giderTarih:String){
        this.giderId = giderId
        this.giderOdemeId = giderOdemeId
        this.giderOdemeUcret = giderOdemeUcret
        this.giderTarih = giderTarih
    }
}