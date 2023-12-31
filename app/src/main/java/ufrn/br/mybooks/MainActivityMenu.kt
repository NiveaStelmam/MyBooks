package ufrn.br.mybooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import ufrn.br.mybooks.database.AppDatabase
import ufrn.br.mybooks.databinding.ActivityMenuBinding

class MainActivityMenu : AppCompatActivity() {

    lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_menu)


        binding.btnCadastrar.setOnClickListener(){
            val intent = Intent(this,MainActivityCadastro::class.java)
            startActivity(intent)
        }

        binding.btnList.setOnClickListener(){
            val intent = Intent(this, MainActivityListar::class.java)
            startActivity(intent)
        }
    }
}