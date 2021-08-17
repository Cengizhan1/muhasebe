package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_work_odemee.*
import java.text.SimpleDateFormat
import java.util.*

class workOdemee : AppCompatActivity() {
    var countOdemeWork:Long =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_work_odemee)

        var databaseOde = FirebaseDatabase.getInstance().reference


        databaseOde.child("worksOdemeler").get().addOnSuccessListener{
            countOdemeWork = it.childrenCount
        }
        btnOde.setOnClickListener {
            var workId = intent.getIntExtra("keyOde",0)
            var odemeId = countOdemeWork + 1
            var odemeTutar = workOdenecekTutar.text.toString().toInt()
            val form = SimpleDateFormat("dd-MM-yyyy HH:mm")
            val tarih = Date()
            val odemeTarih = form.format(tarih).toString()

            databaseOde.child("workOdemeler").child(workId.toString()).child(odemeId.toString())
                .setValue(odemeDataWrite(workId, odemeTutar, odemeId.toInt(), odemeTarih))

            val intent = Intent(this,works::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        val iworkDet = Intent(this,workDetails::class.java)
        startActivity(iworkDet)
        finish()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbardesign,menu);
        return true;
    }
}