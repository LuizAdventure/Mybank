package com.luizalberto.transf.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luizalberto.transf.R
import com.luizalberto.transf.databinding.ActivityFaturasBinding
import com.luizalberto.transf.ui.MainActivity


class Faturas : AppCompatActivity() {

    private lateinit var binding: ActivityFaturasBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaturasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide() // esconde a barra de ação

        val toolbar = binding.toolbarFaturas
        toolbar.title = "Fatura"
        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.setBackgroundColor(getColor(R.color.purple_200))
        toolbar.navigationIcon = getDrawable(R.drawable.ic_voltar)
        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}