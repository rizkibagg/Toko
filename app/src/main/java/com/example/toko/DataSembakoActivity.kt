package com.example.toko

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataSembakoActivity : AppCompatActivity() {
    var hargaberas = 12000; var hargaminyak = 15000; var hargagula = 8000; var hargatelur = 18000; var hargamiegoreng = 120000; var hargamiekuah = 115000
    var itemCount1 = 0; var itemCount2 = 0; var itemCount3 = 0; var itemCount4 = 0; var itemCount5 = 0; var itemCount6 = 0; var totalItems = 0; var totalPrice = 0
    var countberas = 0; var countminyak = 0; var countgula = 0; var counttelur = 0; var countmiegoreng = 0; var countmiekuah = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sembako)

        setToolbar()
        setInitLayout()
        setJmlSembako()
        setDataberas()
        setDataminyak()

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
        }

        //min Rokok Beras
        imageMinus1.setOnClickListener {
            if (countberas > 0) {
                countberas = countberas - 1
                tvPriceberas.text = countberas.toString()
            }
        }

        //add Rokok minyak
        imageAdd2.setOnClickListener {
            countminyak = countminyak + 1
            tvPriceminyak.text = countminyak.toString()
        }

        //min Rokok minyak
        imageMinus2.setOnClickListener {
            if (countminyak > 0) {
                countminyak = countminyak - 1
                tvPriceminyak.text = countminyak.toString()
            }
        }

        //add Rokok gula
        imageAdd3.setOnClickListener {
            countgula = countgula + 1
            tvPricegula.text = countgula.toString()
        }

        //min Rokok gula
        imageMinus3.setOnClickListener {
            if (countgula > 0) {
                countgula = countgula - 1
                tvPricegula.text = countgula.toString()
            }
        }

        //add Rokok telur
        imageAdd4.setOnClickListener {
            counttelur = counttelur + 1
            tvPricetelur.text = counttelur.toString()
        }

        //min Rokok telur
        imageMinus4.setOnClickListener {
            if (counttelur > 0) {
                counttelur = counttelur - 1
                tvPricetelur.text = counttelur.toString()
            }
        }

        //add Rokok miegoreng
        imageAdd5.setOnClickListener {
            countmiegoreng = countmiegoreng + 1
            tvPricemiegoreng.text = countmiegoreng.toString()
        }

        //min Rokok miegoreng
        imageMinus5.setOnClickListener {
            if (countmiegoreng > 0) {
                countmiegoreng = countmiegoreng - 1
                tvPricemiegoreng.text = countmiegoreng.toString()
            }
        }

        //add Rokok miekuah
        imageAdd6.setOnClickListener {
            countmiekuah = countmiekuah + 1
            tvPricemiekuah.text = countmiekuah.toString()
        }

        //min Rokok miegoreng
        imageMinus6.setOnClickListener {
            if (countmiekuah > 0) {
                countmiekuah = countmiekuah - 1
                tvPricemiekuah.text = countmiekuah.toString()
            }
        }
    }

    private fun setDataberas() {
        val tvberas = findViewById<TextView>(R.id.tvberas)
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd1)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus1)
        val tvPriceberas = findViewById<TextView>(R.id.tvPriceberas)

        tvberas.setText(FunctionHelper.rupiahFormat(hargaberas))
        imageAdd1.setOnClickListener(View.OnClickListener {
            itemCount1 = itemCount1 + 1
            tvPriceberas.setText(itemCount1)
            countberas = hargaberas * itemCount1
            setTotalPrice()
        })
        imageMinus1.setOnClickListener(View.OnClickListener {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1
                tvPriceberas.setText(itemCount1)
            }
            countberas = hargaberas * itemCount1
            setTotalPrice()
        })
    }

    private fun setDataminyak() {
        val tvminyak = findViewById<TextView>(R.id.tvminyak)
        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvPriceminyak = findViewById<TextView>(R.id.tvPriceminyak)

        tvminyak.setText(FunctionHelper.rupiahFormat(hargaminyak))
        imageAdd2.setOnClickListener(View.OnClickListener {
            itemCount1 = itemCount1 + 1
            tvPriceminyak.setText(itemCount1)
            countminyak = hargaminyak * itemCount1
            setTotalPrice()
        })
        imageMinus2.setOnClickListener(View.OnClickListener {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1
                tvPriceminyak.setText(itemCount1)
            }
            countminyak = hargaminyak * itemCount1
            setTotalPrice()
        })
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5 + itemCount6
        totalPrice = countberas + countminyak + countgula + counttelur + countmiegoreng + countmiekuah

        tvJumlahBarang.setText(totalItems)
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }

}