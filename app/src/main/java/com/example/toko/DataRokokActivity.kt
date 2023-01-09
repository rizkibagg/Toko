package com.example.toko

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataRokokActivity : AppCompatActivity() {

    var hargaDS12 = 22500; var hargaDS16 = 28000; var harga7612 = 15000; var harga7616 = 20000; var hargaSM12 = 22000
    var countDS12 = 0; var countDS16 = 0; var count7612 = 0; var count7616 = 0; var countSM12 = 0; var totalItems = 0; var totalPrice = 0
    var jmlDS12 = 0; var jmlDS16 = 0; var jml7612 = 0; var jml7616 = 0; var jmlSM12 = 0
    var hargaTotalDS12 = 0; var hargaTotalDS16 = 0; var hargaTotal7612 = 0; var hargaTotal7616 = 0; var hargaTotalSM12 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rokok)

        setToolbar()
        setInitLayout()
        setJmlRokok()
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

    private fun setJmlRokok() {
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd1)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus1)
        val tvPriceDS12 = findViewById<TextView>(R.id.tvPriceDS12)

        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvPriceDS16 = findViewById<TextView>(R.id.tvPriceDS16)

        val imageAdd3 = findViewById<ImageView>(R.id.imageAdd3)
        val imageMinus3 = findViewById<ImageView>(R.id.imageMinus3)
        val tvPrice7612 = findViewById<TextView>(R.id.tvPrice7612)

        val imageAdd4 = findViewById<ImageView>(R.id.imageAdd4)
        val imageMinus4 = findViewById<ImageView>(R.id.imageMinus4)
        val tvPrice7616 = findViewById<TextView>(R.id.tvPrice7616)

        val imageAdd5 = findViewById<ImageView>(R.id.imageAdd5)
        val imageMinus5 = findViewById<ImageView>(R.id.imageMinus5)
        val tvPriceSM12 = findViewById<TextView>(R.id.tvPriceSM12)

        //add Rokok DS12
        imageAdd1.setOnClickListener {
            countDS12 = countDS12 + 1
            tvPriceDS12.text = countDS12.toString()
            jmlDS12 = countDS12.toInt()
            hargaTotalDS12 = hargaDS12 * jmlDS12
            setTotalPrice()
        }

        //min Rokok DS12
        imageMinus1.setOnClickListener {
            if (countDS12 > 0) {
                countDS12 = countDS12 - 1
                tvPriceDS12.text = countDS12.toString()
            }
            jmlDS12 = countDS12.toInt()
            hargaTotalDS12 = hargaDS12 * jmlDS12
            setTotalPrice()
        }

        //add Rokok DS16
        imageAdd2.setOnClickListener {
            countDS16 = countDS16 + 1
            tvPriceDS16.text = countDS16.toString()
            jmlDS16 = countDS16.toInt()
            hargaTotalDS16 = hargaDS16 * jmlDS16
            setTotalPrice()
        }

        //min Rokok DS16
        imageMinus2.setOnClickListener {
            if (countDS16 > 0) {
                countDS16 = countDS16 - 1
                tvPriceDS16.text = countDS16.toString()
            }
            jmlDS16 = countDS16.toInt()
            hargaTotalDS16 = hargaDS16 * jmlDS16
            setTotalPrice()
        }

        //add Rokok 7612
        imageAdd3.setOnClickListener {
            count7612 = count7612 + 1
            tvPrice7612.text = count7612.toString()
            jml7612 = count7612.toInt()
            hargaTotal7612 = harga7612 * jml7612
            setTotalPrice()
        }

        //min Rokok 7612
        imageMinus3.setOnClickListener {
            if (count7612 > 0) {
                count7612 = count7612 - 1
                tvPrice7612.text = count7612.toString()
            }
            jml7612 = count7612.toInt()
            hargaTotal7612 = harga7612 * jml7612
            setTotalPrice()
        }

        //add Rokok 7616
        imageAdd4.setOnClickListener {
            count7616 = count7616 + 1
            tvPrice7616.text = count7616.toString()
            jml7616 = count7616.toInt()
            hargaTotal7616 = harga7616 * jml7616
            setTotalPrice()
        }

        //min Rokok 7616
        imageMinus4.setOnClickListener {
            if (count7616 > 0) {
                count7616 = count7616 - 1
                tvPrice7616.text = count7616.toString()
            }
            jml7616 = count7616.toInt()
            hargaTotal7616 = harga7616 * jml7616
            setTotalPrice()
        }

        //add Rokok SM12
        imageAdd5.setOnClickListener {
            countSM12 = countSM12 + 1
            tvPriceSM12.text = countSM12.toString()
            jmlSM12 = countSM12.toInt()
            hargaTotalSM12 = hargaSM12 * jmlSM12
            setTotalPrice()
        }

        //min Rokok SM12
        imageMinus5.setOnClickListener {
            if (countSM12 > 0) {
                countSM12 = countSM12 - 1
                tvPriceSM12.text = countSM12.toString()
            }
            jmlSM12 = countSM12.toInt()
            hargaTotalSM12 = hargaSM12 * jmlSM12
            setTotalPrice()
        }
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = jmlDS12 + jmlDS16 + jml7612 + jml7616 + jmlSM12
        totalPrice = hargaTotalDS12 + hargaTotalDS16 + hargaTotal7612 + hargaTotal7616 + hargaTotalSM12

        tvJumlahBarang.setText("$totalItems items")
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }

    private fun setInputData() {
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        btnCheckout.setOnClickListener(View.OnClickListener {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(
                    this@DataRokokActivity,
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
                    this@DataRokokActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }

}