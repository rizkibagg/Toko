package com.example.toko

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import com.example.toko.R
import com.example.toko.HistoryActivity
import com.example.toko.DataRokokActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val History = findViewById<LinearLayout>(R.id.layoutHistory)
        val cvRokok = findViewById<CardView>(R.id.cvRokok)
        val cvSembako = findViewById<CardView>(R.id.cvSembako)
        val cvSnack = findViewById<CardView>(R.id.cvSnack)
        val cvLain = findViewById<CardView>(R.id.cvLain)

        History.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        cvRokok.setOnClickListener {
            val intent = Intent(this@MainActivity, DataRokokActivity::class.java)
            startActivity(intent)
        }

        cvSembako.setOnClickListener {
            val intent = Intent(this@MainActivity, DataSembakoActivity::class.java)
            startActivity(intent)
        }

        cvSnack.setOnClickListener {
            val intent = Intent(this@MainActivity, DataSnackActivity::class.java)
            startActivity(intent)
        }

        cvLain.setOnClickListener {
            val intent = Intent(this@MainActivity, DataLainActivity::class.java)
            startActivity(intent)
        }

    }

}