package com.example.toko

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.toko.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers


class InputDataViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        fun addDataRokok(
            totalItems: Int, totalPrice: Int, status: String
        ) {
            Completable.fromAction {
                val modelDatabase = ModelDatabase()
                modelDatabase.totalItems = totalItems
                modelDatabase.totalPrice = totalPrice
                modelDatabase.status = status
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        }
    }

}