package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_works.*

class works : AppCompatActivity() {

    private lateinit var workArrayList : ArrayList<sonWorks>
    private lateinit var workRecycler : RecyclerView

    val databaseWork = FirebaseDatabase.getInstance().getReference("works")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_works)

        workRecycler = findViewById(R.id.workRecycler)
        workRecycler.layoutManager = LinearLayoutManager(this)
        workRecycler.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))


        btnGoWorkAdd.setOnClickListener{
            val intent = Intent(this,AddWork::class.java)
            startActivity(intent)
        }

        workArrayList = arrayListOf<sonWorks>()

        getWork()
    }

    private fun getWork(){
        databaseWork.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (work in snapshot.children){
                        val w = work.getValue(sonWorks::class.java)
                        workArrayList.add(w!!)
                    }
                    workRecycler.adapter = workAdapter(workArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}