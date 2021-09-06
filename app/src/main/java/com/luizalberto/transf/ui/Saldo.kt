package com.luizalberto.transf.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.luizalberto.transf.R
import com.luizalberto.transf.databinding.ActivitySaldoBinding


class Saldo : AppCompatActivity() {

    private lateinit var binding: ActivitySaldoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaldoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarSaldo // guarda o id dentro de uma variável
        toolbar.title = "Saldo"
        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.setBackgroundColor(getColor(R.color.purple_200))
        //toolbar.setTitleMargin(400,0,400,0)
        toolbar.navigationIcon = getDrawable(R.drawable.ic_voltar)
        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}