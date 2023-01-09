package com.example.toko

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataSembakoActivity : AppCompatActivity() {
    var hargaberas = 12000; var hargaminyak = 15000; var hargagula = 8000; var hargatelur = 18000; var hargamiegoreng = 120000; var hargamiekuah = 115000
    var countberas = 0; var countminyak = 0; var countgula = 0; var counttelur = 0; var countmiegoreng = 0; var countmiekuah = 0; var totalItems = 0; var totalPrice = 0
    var jmlberas = 0; var jmlminyak = 0; var jmlgula = 0; var jmltelur = 0; var jmlmiegoreng = 0; var jmlmiekuah = 0
    var hargaTotalberas = 0; var hargaTotalminyak = 0; var hargaTotalgula = 0; var hargaTotaltelur = 0; var hargaTotalmiegoreng = 0; var hargaTotalmiekuah = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sembako)

        setToolbar()
        setInitLayout()
        setJmlSembako()

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

    private fun setJmlSembako() {
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd1)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus1)
        val tvPriceberas = findViewById<TextView>(R.id.tvPriceberas)

        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvPriceminyak = findViewById<TextView>(R.id.tvPriceminyak)

        val imageAdd3 = findViewById<ImageView>(R.id.imageAdd3)
        val imageMinus3 = findViewById<ImageView>(R.id.imageMinus3)
        val tvPricegula = findViewById<TextView>(R.id.tvPricegula)

        val imageAdd4 = findViewById<ImageView>(R.id.imageAdd4)
        val imageMinus4 = findViewById<ImageView>(R.id.imageMinus4)
        val tvPricetelur = findViewById<TextView>(R.id.tvPricetelur)

        val imageAdd5 = findViewById<ImageView>(R.id.imageAdd5)
        val imageMinus5 = findViewById<ImageView>(R.id.imageMinus5)
        val tvPricemiegoreng = findViewById<TextView>(R.id.tvPricemiegoreng)

        val imageAdd6 = findViewById<ImageView>(R.id.imageAdd6)
        val imageMinus6 = findViewById<ImageView>(R.id.imageMinus6)
        val tvPricemiekuah = findViewById<TextView>(R.id.tvPricemiekuah)

        //add Rokok Beras
        imageAdd1.setOnClickListener {
            countberas = countberas + 1
            tvPriceberas.text = countberas.toString()
            jmlberas = countberas.toInt()
            hargaTotalberas = hargaberas * jmlberas
            setTotalPrice()
        }

        //min Beras
        imageMinus1.setOnClickListener {
            if (countberas > 0) {
                countberas = countberas - 1
                tvPriceberas.text = countberas.toString()
            }
            jmlberas = countberas.toInt()
            hargaTotalberas = hargaberas * jmlberas
            setTotalPrice()
        }

        //add minyak
        imageAdd2.setOnClickListener {
            countminyak = countminyak + 1
            tvPriceminyak.text = countminyak.toString()
            jmlminyak = countminyak.toInt()
            hargaTotalminyak = hargaminyak * jmlminyak
            setTotalPrice()
        }

        //min minyak
        imageMinus2.setOnClickListener {
            if (countminyak > 0) {
                countminyak = countminyak - 1
                tvPriceminyak.text = countminyak.toString()
            }
            jmlminyak = countminyak.toInt()
            hargaTotalminyak = hargaminyak * jmlminyak
            setTotalPrice()
        }

        //add gula
        imageAdd3.setOnClickListener {
            countgula = countgula + 1
            tvPricegula.text = countgula.toString()
            jmlgula = countgula.toInt()
            hargaTotalgula = hargagula * jmlgula
            setTotalPrice()
        }

        //min gula
        imageMinus3.setOnClickListener {
            if (countgula > 0) {
                countgula = countgula - 1
                tvPricegula.text = countgula.toString()
            }
            jmlgula = countgula.toInt()
            hargaTotalgula = hargagula * jmlgula
            setTotalPrice()
        }

        //add telur
        imageAdd4.setOnClickListener {
            counttelur = counttelur + 1
            tvPricetelur.text = counttelur.toString()
            jmltelur = counttelur.toInt()
            hargaTotaltelur = hargatelur * jmltelur
            setTotalPrice()
        }

        //min telur
        imageMinus4.setOnClickListener {
            if (counttelur > 0) {
                counttelur = counttelur - 1
                tvPricetelur.text = counttelur.toString()
            }
            jmltelur = counttelur.toInt()
            hargaTotaltelur = hargatelur * jmltelur
            setTotalPrice()
        }

        //add miegoreng
        imageAdd5.setOnClickListener {
            countmiegoreng = countmiegoreng + 1
            tvPricemiegoreng.text = countmiegoreng.toString()
            jmlmiegoreng = countmiegoreng.toInt()
            hargaTotalmiegoreng = hargamiegoreng * jmlmiegoreng
            setTotalPrice()
        }

        //min miegoreng
        imageMinus5.setOnClickListener {
            if (countmiegoreng > 0) {
                countmiegoreng = countmiegoreng - 1
                tvPricemiegoreng.text = countmiegoreng.toString()
            }
            jmlmiegoreng = countmiegoreng.toInt()
            hargaTotalmiegoreng = hargamiegoreng * jmlmiegoreng
            setTotalPrice()
        }

        //add miekuah
        imageAdd6.setOnClickListener {
            countmiekuah = countmiekuah + 1
            tvPricemiekuah.text = countmiekuah.toString()
            jmlmiekuah = countmiekuah.toInt()
            hargaTotalmiekuah = hargamiekuah * jmlmiekuah
            setTotalPrice()
        }

        //min miegoreng
        imageMinus6.setOnClickListener {
            if (countmiekuah > 0) {
                countmiekuah = countmiekuah - 1
                tvPricemiekuah.text = countmiekuah.toString()
            }
            jmlmiekuah = countmiekuah.toInt()
            hargaTotalmiekuah = hargamiekuah * jmlmiekuah
            setTotalPrice()
        }
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = jmlberas + jmlminyak + jmlgula + jmltelur + jmlmiegoreng + jmlmiekuah
        totalPrice = hargaTotalberas + hargaTotalminyak + hargaTotalgula + hargaTotaltelur + hargaTotalmiegoreng + hargaTotalmiekuah

        tvJumlahBarang.setText("$totalItems items")
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }

    private fun setInputData() {
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        btnCheckout.setOnClickListener(View.OnClickListener {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(
                    this@DataSembakoActivity,
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
                    this@DataSembakoActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }

}