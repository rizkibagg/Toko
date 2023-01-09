package com.example.toko

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataLainActivity : AppCompatActivity() {
    var hargaaqua = 19000; var hargalemineral = 20000; var hargagas3kg = 21000; var hargagas5kg = 80000
    var countaqua = 0; var countlemineral = 0; var countgas3kg = 0; var countgas5kg = 0; var totalItems = 0; var totalPrice = 0
    var jmlaqua = 0; var jmllemineral = 0; var jmlgas3kg = 0; var jmlgas5kg = 0
    var hargaTotalaqua = 0; var hargaTotallemineral = 0; var hargaTotalgas3kg = 0; var hargaTotalgas5kg = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lain)

        setToolbar()
        setInitLayout()
        setJmlSnack()
        setInputData()

    }

    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(true)
        }
    }

    private fun setInitLayout() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)
        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        tvJumlahBarang.setText("0 items")
        tvTotalPrice.setText("Rp 0")
        tvInfo.setText("Harga sewaktu-waktu bisa berubah.")
    }

    private fun setJmlSnack() {
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd1)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus1)
        val tvPriceaqua = findViewById<TextView>(R.id.tvPriceaqua)

        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvPricelemineral = findViewById<TextView>(R.id.tvPricelemineral)

        val imageAdd3 = findViewById<ImageView>(R.id.imageAdd3)
        val imageMinus3 = findViewById<ImageView>(R.id.imageMinus3)
        val tvPricegas3kg = findViewById<TextView>(R.id.tvPricegas3kg)

        val imageAdd4 = findViewById<ImageView>(R.id.imageAdd4)
        val imageMinus4 = findViewById<ImageView>(R.id.imageMinus4)
        val tvPricegas5kg = findViewById<TextView>(R.id.tvPricegas5kg)

        //add Aqua
        imageAdd1.setOnClickListener {
            countaqua = countaqua + 1
            tvPriceaqua.text = countaqua.toString()
            jmlaqua = countaqua.toInt()
            hargaTotalaqua = hargaaqua * jmlaqua
            setTotalPrice()
        }

        //min Aqua
        imageMinus1.setOnClickListener {
            if (countaqua > 0) {
                countaqua = countaqua - 1
                tvPriceaqua.text = countaqua.toString()
            }
            jmlaqua = countaqua.toInt()
            hargaTotalaqua = hargaaqua * jmlaqua
            setTotalPrice()
        }

        //add lemineral
        imageAdd2.setOnClickListener {
            countlemineral = countlemineral + 1
            tvPricelemineral.text = countlemineral.toString()
            jmllemineral = countlemineral.toInt()
            hargaTotallemineral = hargalemineral * jmllemineral
            setTotalPrice()
        }

        //min lemineral
        imageMinus2.setOnClickListener {
            if (countlemineral > 0) {
                countlemineral = countlemineral - 1
                tvPricelemineral.text = countlemineral.toString()
            }
            jmllemineral = countlemineral.toInt()
            hargaTotallemineral = hargalemineral * jmllemineral
            setTotalPrice()
        }

        //add gas3kg
        imageAdd3.setOnClickListener {
            countgas3kg = countgas3kg + 1
            tvPricegas3kg.text = countgas3kg.toString()
            jmlgas3kg = countgas3kg.toInt()
            hargaTotalgas3kg = hargagas3kg * jmlgas3kg
            setTotalPrice()
        }

        //min gas3kg
        imageMinus3.setOnClickListener {
            if (countgas3kg > 0) {
                countgas3kg = countgas3kg - 1
                tvPricegas3kg.text = countgas3kg.toString()
            }
            jmlgas3kg = countgas3kg.toInt()
            hargaTotalgas3kg = hargagas3kg * jmlgas3kg
            setTotalPrice()
        }

        //add gas5kg
        imageAdd4.setOnClickListener {
            countgas5kg = countgas5kg + 1
            tvPricegas5kg.text = countgas5kg.toString()
            jmlgas5kg = countgas5kg.toInt()
            hargaTotalgas5kg= hargagas5kg * jmlgas5kg
            setTotalPrice()
        }

        //min gas5kg
        imageMinus4.setOnClickListener {
            if (countgas5kg > 0) {
                countgas5kg = countgas5kg - 1
                tvPricegas5kg.text = countgas5kg.toString()
            }
            jmlgas5kg = countgas5kg.toInt()
            hargaTotalgas5kg= hargagas5kg * jmlgas5kg
            setTotalPrice()
        }
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = jmlaqua + jmllemineral + jmlgas3kg + jmlgas5kg
        totalPrice = hargaTotalaqua + hargaTotallemineral + hargaTotalgas3kg + hargaTotalgas5kg

        tvJumlahBarang.setText("$totalItems items")
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }

    private fun setInputData() {
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        btnCheckout.setOnClickListener(View.OnClickListener {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(
                    this@DataLainActivity,
                    "Harap pilih jenis barang!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                InputDataViewModel.addDataRokok(
                    totalItems,
                    totalPrice,
                    "1"
                )
                Toast.makeText(
                    this@DataLainActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }

}