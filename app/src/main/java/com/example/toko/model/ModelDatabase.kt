package com.example.toko.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "tbl_data")
class ModelDatabase : Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid = 0

    @ColumnInfo(name = "totalItems")
    var totalItems = 0

    @ColumnInfo(name = "totalPrice")
    var totalPrice = 0

    @ColumnInfo(name = "status")
    lateinit var status: String

}