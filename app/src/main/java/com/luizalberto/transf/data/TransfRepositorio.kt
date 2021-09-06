package com.luizalberto.transf.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TransfRepositorio (private val dao: TransferenciaDao){

    fun insert(transf: Transf) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(transf)

        }

    }

    fun getAll() = dao.getAll()

}
