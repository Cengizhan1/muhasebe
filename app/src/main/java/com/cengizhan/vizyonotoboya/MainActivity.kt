package com.cengizhan.vizyonotoboya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGoWork.setOnClickListener{
            val intent = Intent(this,works::class.java)
            startActivity(intent)
        }

        btnGoGider.setOnClickListener{
            val intent = Intent(this,giderler::class.java)
            startActivity(intent)
        }

        btnGoOzet.setOnClickListener{
            val intent = Intent(this,ozet::class.java)
            startActivity(intent)
        }
    }

}