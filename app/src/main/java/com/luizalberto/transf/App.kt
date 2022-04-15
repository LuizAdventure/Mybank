package com.luizalberto.transf

import android.app.Application
import com.luizalberto.transf.data.AppDatabase
import com.luizalberto.transf.data.TransfRepositorio



class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repositorio by lazy { TransfRepositorio (database.transferenciaDao()) }
}