package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_giderler.*

class giderler : AppCompatActivity() {

    private lateinit var giderArrayList : ArrayList<sonGiderler>
    private lateinit var giderRecycler : RecyclerView

    val database = FirebaseDatabase.getInstance().getReference("giderler")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giderler)

        giderRecycler = findViewById(R.id.giderRecycler)
        giderRecycler.layoutManager = LinearLayoutManager(this)
        giderRecycler.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))


        btnGoGiderEkle.setOnClickListener {
            val intent = Intent(this, giderEkle::class.java)
            startActivity(intent)
            finish()
        }



        giderArrayList = arrayListOf<sonGiderler>()

        getGider()



    }

    private fun getGider(){
        database.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (gider in snapshot.children) {
                        val c = gider.child("giderControl").getValue()
                        if (c == true) {
                            val g = gider.getValue(sonGiderler::class.java)
                            giderArrayList.add(g!!)
                        }
                    }
                    giderRecycler.adapter = giderAdapter(giderArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }

    override fun onBackPressed() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}