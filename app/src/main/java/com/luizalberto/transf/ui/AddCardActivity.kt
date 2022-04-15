package com.luizalberto.transf.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.luizalberto.transf.App
import com.luizalberto.transf.R
import com.luizalberto.transf.data.Transf
import com.luizalberto.transf.databinding.AddTransferenciaBinding

class AddCardActivity : AppCompatActivity(){

    private val binding by lazy{AddTransferenciaBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repositorio)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }
    private fun insertListeners() {
        binding.btnConfirmar.setOnClickListener {
            val transf = Transf(
                para = binding.tilPara.editText?.text.toString(),
                valor = binding.tilValor.editText?.text.toString()
            )
            mainViewModel.insert(transf)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}