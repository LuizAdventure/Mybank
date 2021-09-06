package com.luizalberto.transf.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TransferenciaDao {

      @Query("SELECT * FROM Transf")
      fun getAll(): LiveData<List<Transf>>

      @Insert(onConflict = OnConflictStrategy.IGNORE)
      suspend fun insert(transf: Transf)

}