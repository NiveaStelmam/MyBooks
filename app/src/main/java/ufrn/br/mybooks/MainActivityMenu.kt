package ufrn.br.mybooks

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
        setContentView(R.layout.activity_menu)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_menu)



        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "banco_aula.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()
    }
}