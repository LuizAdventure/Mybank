package com.luizalberto.transf.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.luizalberto.transf.App
import com.luizalberto.transf.Util.Image
import com.luizalberto.transf.databinding.MainTransferenciaBinding


class MainTransferencia : AppCompatActivity(){

    private val binding by lazy { MainTransferenciaBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repositorio)

    }

    private val adapter by lazy { TransferenciaAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllTransferencia()
        insertListener()
    }



    private fun insertListener(){
        binding.fab.setOnClickListener{
            val intent = Intent(this, AddTransferencia::class.java)
            startActivity(intent)

        }


        adapter.listenerShare = { card ->
            Image.share(this@MainTransferencia, card)
        }


    }

    private fun getAllTransferencia(){
        mainViewModel.getAll().observe(this, { transf ->
            adapter.submitList(transf)
        })




    }


}