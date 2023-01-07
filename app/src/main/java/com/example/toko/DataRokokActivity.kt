package com.example.toko

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataRokokActivity : AppCompatActivity() {

    var hargaDS12 = 22500; var hargaDS16 = 28000; var harga7612 = 15000; var harga7616 = 20000; var hargaSM12 = 22000
    var itemCount1 = 0; var itemCount2 = 0; var itemCount3 = 0; var itemCount4 = 0; var itemCount5 = 0; var totalItems = 0; var totalPrice = 0
    var countDS12 = 0; var countDS16 = 0; var count7612 = 0; var count7616 = 0; var countSM12 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rokok)

        setToolbar()
        setInitLayout()
        setJmlRokok()
        setDataDS12()
        setDataDS16()

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
        }

        //min Rokok DS12
        imageMinus1.setOnClickListener {
            if (countDS12 > 0) {
                countDS12 = countDS12 - 1
                tvPriceDS12.text = countDS12.toString()
            }
        }

        //add Rokok DS16
        imageAdd2.setOnClickListener {
            countDS16 = countDS16 + 1
            tvPriceDS16.text = countDS16.toString()
        }

        //min Rokok DS16
        imageMinus2.setOnClickListener {
            if (countDS16 > 0) {
                countDS16 = countDS16 - 1
                tvPriceDS16.text = countDS16.toString()
            }
        }

        //add Rokok 7612
        imageAdd3.setOnClickListener {
            count7612 = count7612 + 1
            tvPrice7612.text = count7612.toString()
        }

        //min Rokok 7612
        imageMinus3.setOnClickListener {
            if (count7612 > 0) {
                count7612 = count7612 - 1
                tvPrice7612.text = count7612.toString()
            }
        }

        //add Rokok 7616
        imageAdd4.setOnClickListener {
            count7616 = count7616 + 1
            tvPrice7616.text = count7616.toString()
        }

        //min Rokok 7616
        imageMinus4.setOnClickListener {
            if (count7616 > 0) {
                count7616 = count7616 - 1
                tvPrice7616.text = count7616.toString()
            }
        }

        //add Rokok SM12
        imageAdd5.setOnClickListener {
            countSM12 = countSM12 + 1
            tvPriceSM12.text = countSM12.toString()
        }

        //min Rokok SM12
        imageMinus5.setOnClickListener {
            if (countSM12 > 0) {
                countSM12 = countSM12 - 1
                tvPriceSM12.text = countSM12.toString()
            }
        }
    }

    private fun setDataDS12() {
        val tvDS12 = findViewById<TextView>(R.id.tvDS12)
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd1)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus1)
        val tvPriceDS12 = findViewById<TextView>(R.id.tvPriceDS12)

        tvDS12.setText(FunctionHelper.rupiahFormat(hargaDS12))
        imageAdd1.setOnClickListener(View.OnClickListener {
            itemCount1 = itemCount1 + 1
            tvPriceDS12.setText(itemCount1)
            countDS12 = hargaDS12 * itemCount1
            setTotalPrice()
        })
        imageMinus1.setOnClickListener(View.OnClickListener {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1
                tvPriceDS12.setText(itemCount1)
            }
            countDS12 = hargaDS12 * itemCount1
            setTotalPrice()
        })
    }

    private fun setDataDS16() {
        val tvDS16 = findViewById<TextView>(R.id.tvDS16)
        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvPriceDS16 = findViewById<TextView>(R.id.tvPriceDS16)

        tvDS16.setText(FunctionHelper.rupiahFormat(hargaDS16))
        imageAdd2.setOnClickListener(View.OnClickListener {
            itemCount2 = itemCount2 + 1
            tvPriceDS16.setText(itemCount2)
            countDS16 = hargaDS16 * itemCount2
            setTotalPrice()
        })
        imageMinus2.setOnClickListener(View.OnClickListener {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1
                tvPriceDS16.setText(itemCount2)
            }
            countDS16 = hargaDS16 * itemCount2
            setTotalPrice()
        })
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5
        totalPrice = countDS12 + countDS16 + count7612 + count7616 + countSM12

        tvJumlahBarang.setText(totalItems)
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }

}