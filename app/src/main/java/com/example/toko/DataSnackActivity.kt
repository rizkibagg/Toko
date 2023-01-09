package com.example.toko

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataSnackActivity : AppCompatActivity() {
    var hargabengbeng = 2000; var hargasarigandum = 2000; var hargacokicoki = 1000; var hargamalkist = 1000; var hargataro = 1000
    var countbengbeng = 0; var countsarigandum = 0; var countcokicoki = 0; var countmalkist = 0; var counttaro = 0; var totalItems = 0; var totalPrice = 0
    var jmlbengbeng = 0; var jmlsarigandum = 0; var jmlcokicoki = 0; var jmlmalkist = 0; var jmltaro = 0
    var hargaTotalbengbeng = 0; var hargaTotalsarigandum = 0; var hargaTotalcokicoki = 0; var hargaTotalmalkist = 0; var hargaTotaltaro = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack)

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
        val tvPricebengbeng = findViewById<TextView>(R.id.tvPricebengbeng)

        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvPricesarigandum = findViewById<TextView>(R.id.tvPricesarigandum)

        val imageAdd3 = findViewById<ImageView>(R.id.imageAdd3)
        val imageMinus3 = findViewById<ImageView>(R.id.imageMinus3)
        val tvPricecokicoki = findViewById<TextView>(R.id.tvPricecokicoki)

        val imageAdd4 = findViewById<ImageView>(R.id.imageAdd4)
        val imageMinus4 = findViewById<ImageView>(R.id.imageMinus4)
        val tvPricemalkist = findViewById<TextView>(R.id.tvPricemalkist)

        val imageAdd5 = findViewById<ImageView>(R.id.imageAdd5)
        val imageMinus5 = findViewById<ImageView>(R.id.imageMinus5)
        val tvPricetaro = findViewById<TextView>(R.id.tvPricetaro)

        //add Beng Beng
        imageAdd1.setOnClickListener {
            countbengbeng = countbengbeng + 1
            tvPricebengbeng.text = countbengbeng.toString()
            jmlbengbeng = countbengbeng.toInt()
            hargaTotalbengbeng = hargabengbeng * jmlbengbeng
            setTotalPrice()
        }

        //min Beng Beng
        imageMinus1.setOnClickListener {
            if (countbengbeng > 0) {
                countbengbeng = countbengbeng - 1
                tvPricebengbeng.text = countbengbeng.toString()
            }
            jmlbengbeng = countbengbeng.toInt()
            hargaTotalbengbeng = hargabengbeng * jmlbengbeng
            setTotalPrice()
        }

        //add Sari Gandum
        imageAdd2.setOnClickListener {
            countsarigandum = countsarigandum + 1
            tvPricesarigandum.text = countsarigandum.toString()
            jmlsarigandum = countsarigandum.toInt()
            hargaTotalsarigandum = hargasarigandum * jmlsarigandum
            setTotalPrice()
        }

        //min Sari Gandum
        imageMinus2.setOnClickListener {
            if (countsarigandum > 0) {
                countsarigandum = countsarigandum - 1
                tvPricesarigandum.text = countsarigandum.toString()
            }
            jmlsarigandum = countsarigandum.toInt()
            hargaTotalsarigandum = hargasarigandum * jmlsarigandum
            setTotalPrice()
        }

        //add Coki Coki
        imageAdd3.setOnClickListener {
            countcokicoki = countcokicoki + 1
            tvPricecokicoki.text = countcokicoki.toString()
            jmlcokicoki = countcokicoki.toInt()
            hargaTotalcokicoki = hargacokicoki * jmlcokicoki
            setTotalPrice()
        }

        //min Coki Coki
        imageMinus3.setOnClickListener {
            if (countcokicoki > 0) {
                countcokicoki = countcokicoki - 1
                tvPricecokicoki.text = countcokicoki.toString()
            }
            jmlcokicoki = countcokicoki.toInt()
            hargaTotalcokicoki = hargacokicoki * jmlcokicoki
            setTotalPrice()
        }

        //add Malkist
        imageAdd4.setOnClickListener {
            countmalkist = countmalkist + 1
            tvPricemalkist.text = countmalkist.toString()
            jmlmalkist = countmalkist.toInt()
            hargaTotalmalkist = hargamalkist * jmlmalkist
            setTotalPrice()
        }

        //min Malkist
        imageMinus4.setOnClickListener {
            if (countmalkist > 0) {
                countmalkist = countmalkist - 1
                tvPricemalkist.text = countmalkist.toString()
            }
            jmlmalkist = countmalkist.toInt()
            hargaTotalmalkist = hargamalkist * jmlmalkist
            setTotalPrice()
        }

        //add Taro
        imageAdd5.setOnClickListener {
            counttaro = counttaro + 1
            tvPricetaro.text = counttaro.toString()
            jmltaro = counttaro.toInt()
            hargaTotaltaro = hargataro * jmltaro
            setTotalPrice()
        }

        //min Taro
        imageMinus5.setOnClickListener {
            if (counttaro > 0) {
                counttaro = counttaro - 1
                tvPricetaro.text = counttaro.toString()
            }
            jmltaro = counttaro.toInt()
            hargaTotaltaro = hargataro * jmltaro
            setTotalPrice()
        }

    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = jmlbengbeng + jmlsarigandum + jmlcokicoki + jmlmalkist + jmltaro
        totalPrice = hargaTotalbengbeng + hargaTotalsarigandum + hargaTotalcokicoki + hargaTotalmalkist + hargaTotaltaro

        tvJumlahBarang.setText("$totalItems items")
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }

    private fun setInputData() {
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        btnCheckout.setOnClickListener(View.OnClickListener {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(
                    this@DataSnackActivity,
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
                    this@DataSnackActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }

}