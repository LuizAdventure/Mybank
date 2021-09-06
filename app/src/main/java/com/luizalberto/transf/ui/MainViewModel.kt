package com.luizalberto.transf.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luizalberto.transf.data.Transf
import com.luizalberto.transf.data.TransfRepositorio
import java.lang.IllegalArgumentException

class MainViewModel(private val transfRepositorio: TransfRepositorio): ViewModel(){

    fun insert(transf: Transf){
        transfRepositorio.insert(transf  )

    }
    fun getAll() : LiveData<List<Transf>> {
        return transfRepositorio.getAll()

    }
}

class MainViewModelFactory(private val repositorio: TransfRepositorio): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}