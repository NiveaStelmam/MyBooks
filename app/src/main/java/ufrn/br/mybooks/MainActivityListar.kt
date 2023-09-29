package ufrn.br.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ufrn.br.mybooks.databinding.ActivityListarBinding
class MainActivityListar : AppCompatActivity() {

    lateinit var binding : ActivityListarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_listar)
    }
}