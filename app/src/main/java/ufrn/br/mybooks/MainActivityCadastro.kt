package ufrn.br.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ufrn.br.mybooks.databinding.ActivityCadastroBinding


class MainActivityCadastro : AppCompatActivity() {

    lateinit var binding : ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_cadastro)

    }
}