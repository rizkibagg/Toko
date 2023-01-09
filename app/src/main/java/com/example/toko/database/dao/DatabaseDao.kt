package com.example.toko.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.toko.model.ModelDatabase


@Dao
interface DatabaseDao {
    @Query("SELECT * FROM tbl_data")
    fun getAllData(): LiveData<List<ModelDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_data WHERE uid= :uid")
    fun deleteDataById(uid: Int)
}