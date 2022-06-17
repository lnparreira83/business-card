package com.lnp.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.lnp.businesscard.App
import com.lnp.businesscard.R
import com.lnp.businesscard.data.BusinessCard
import com.lnp.businesscard.databinding.*


class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private  val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                empresa = binding.tilCompany.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                github = binding.tilGithub.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()

            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.cadastro_com_sucesso, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}