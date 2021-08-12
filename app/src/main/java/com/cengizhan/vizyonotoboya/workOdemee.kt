package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_work_odemee.*

class workOdemee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_work_odemee)

        var databaseOde = FirebaseDatabase.getInstance().reference
        btnOde.setOnClickListener {
            var workId = intent.getIntExtra("keyOde",0)
            var odemeId = (0..10000).random()
            var odemeTutar = workOdenecekTutar.text.toString().toInt()
            var odemeTarih = "2020/08/08"

            databaseOde.child("workOdemeler").child(workId.toString()).child(odemeId.toString())
                .setValue(odemeDataWrite(workId, odemeTutar, odemeId, odemeTarih))

            val intent = Intent(this,works::class.java)
            startActivity(intent)
            finish()
        }
    }
}