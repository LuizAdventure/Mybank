package com.luizalberto.transf.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transf(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val para: String,
    val valor: String
)