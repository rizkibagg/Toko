package com.example.toko

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.toko.database.DatabaseClient.Companion.getInstance
import com.example.toko.database.dao.DatabaseDao
import com.example.toko.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers


class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    fun deleteDataById(uid: Int) {

    }


}