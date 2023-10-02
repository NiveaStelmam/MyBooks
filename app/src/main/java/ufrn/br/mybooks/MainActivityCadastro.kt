package ufrn.br.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import ufrn.br.mybooks.database.AppDatabase
import ufrn.br.mybooks.databinding.ActivityCadastroBinding
import ufrn.br.mybooks.model.Livro


class MainActivityCadastro : AppCompatActivity() {

    lateinit var binding : ActivityCadastroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_cadastro)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "banco_pdm.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()


        binding.btnSalvar.setOnClickListener {
            val titulo = binding.editTextTitulo.text.toString()
            val autor = binding.editTextAutor.text.toString()
            val ano = binding.editTextAno.text.toString().toInt() // Converte o ano para Int
            val nota = binding.avaliacao.rating

            // Cria o objeto Livro com os dados
            val livro = Livro(titulo, autor, ano, nota)

            // Salvar o livro no bd
            db.livrosDao().inserir(livro)

            //msg na snackbar
            Snackbar.make(it, "Livro salvo com sucesso!", Snackbar.LENGTH_SHORT).show()

            // Limpa os campos depois que salvar
            binding.editTextTitulo.text.clear()
            binding.editTextAutor.text.clear()
            binding.editTextAno.text.clear()
            binding.avaliacao.rating = 0.0f
        }

        binding.btnCancelar.setOnClickListener {
            // Volta para a tela de menu sem salvar
            finish()
        }


    }
}