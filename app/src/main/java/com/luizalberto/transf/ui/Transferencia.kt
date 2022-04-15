package com.luizalberto.transf.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.luizalberto.transf.App
import com.luizalberto.transf.Util.Image
import com.luizalberto.transf.databinding.MainTransferenciaBinding


class Transferencia : AppCompatActivity() {


    private val binding by lazy { MainTransferenciaBinding.inflate(layoutInflater) }
    private val adapter by lazy { TransferenciaAdapter() }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repositorio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        getAllCard()
        binding.rvCards.adapter = adapter
        insertListener()
    }

    private fun setUpPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }

    private fun insertListener() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@Transferencia, card)
        }
    }

    private fun getAllCard() {
        mainViewModel.getAll().observe(this, { Cards ->
            adapter.submitList(Cards)
        })
    }


}