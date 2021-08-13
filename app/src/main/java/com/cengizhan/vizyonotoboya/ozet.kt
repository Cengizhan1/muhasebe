package com.cengizhan.vizyonotoboya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_ozet.*
import kotlinx.android.synthetic.main.activity_work_details.*

class ozet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ozet)


        var database = FirebaseDatabase.getInstance().getReference("works")
        var database2 = FirebaseDatabase.getInstance().getReference("giderler")
        var toplamUcret = 0
        var toplamGider = 0
        var kalan = 0
        var topNalbur = 0
        var topYemek = 0
        var topFatura = 0
        var topDukkan = 0
        var topEv = 0
        var topDiger = 0

        var getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (i in snapshot.children) {
                    var ucret = i.child("ucret").getValue()
                    toplamUcret = ucret.toString().toInt() + toplamUcret
                }

                txtOzetToplam.text = ("Toplam gelir :  "+ toplamUcret.toString()+ " TL")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)


        var getdata2 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (j in snapshot.children) {
                    var gider = j.child("giderUcret").getValue()
                    toplamGider = gider.toString().toInt() + toplamGider
                    kalan = toplamUcret - toplamGider

                    if(j.child("giderTürü").getValue().toString() == "Nalbur")
                    {
                        var nalburGider = j.child("giderUcret").getValue()
                        topNalbur = nalburGider.toString().toInt() + topNalbur
                    }
                    if(j.child("giderTürü").getValue().toString() == "Yemek")
                    {
                        var yemekGider = j.child("giderUcret").getValue()
                        topYemek = yemekGider.toString().toInt() + topYemek
                    }
                    if(j.child("giderTürü").getValue().toString() == "Faturalar")
                    {
                        var faturaGider = j.child("giderUcret").getValue()
                        topFatura = faturaGider.toString().toInt() + topFatura
                    }
                    if(j.child("giderTürü").getValue().toString() == "Dukkan masrafı")
                    {
                        var dukkanGider = j.child("giderUcret").getValue()
                        topDukkan = dukkanGider.toString().toInt() + topDukkan
                    }
                    if(j.child("giderTürü").getValue().toString() == "Ev masrafı")
                    {
                        var evGider = j.child("giderUcret").getValue()
                        topEv = evGider.toString().toInt() + topEv
                    }
                    if(j.child("giderTürü").getValue().toString() == "Diğer")
                    {
                        var digerGider = j.child("giderUcret").getValue()
                        topDiger = digerGider.toString().toInt() + topDiger
                    }
                }
                txtOzetNalbur.text = ("Nalbur :  "+topNalbur.toString() + " TL")
                txtOzetDiger.text = ("Yemek :  "+topYemek.toString() + " TL")
                txtOzetEvMasrafı.text = ("Faturalar :  "+topFatura.toString() + " TL")
                txtOzetDukkanMasrafi.text = ("Dükkan masrafı :  "+topDukkan.toString() + " TL")
                txtOzetFatura.text = ("Ev masrafı :  "+topEv.toString() + " TL")
                txtOzetYemek.text = ("Diğer :  "+topDiger.toString() + " TL")

                txtOzetNet.text = ("Net gelir :  "+kalan.toString() + " TL")
                txtToplamGider.text = ("Toplam gider :  "+ toplamGider.toString()+" TL")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database2.addValueEventListener(getdata2)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }
}