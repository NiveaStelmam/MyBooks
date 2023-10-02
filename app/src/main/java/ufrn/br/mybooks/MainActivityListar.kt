package ufrn.br.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import ufrn.br.mybooks.database.AppDatabase
import ufrn.br.mybooks.databinding.ActivityListarBinding
import ufrn.br.mybooks.model.Livro
import ufrn.br.mybooks.repository.LivrosDao


class MainActivityListar : AppCompatActivity() {

    lateinit var binding : ActivityListarBinding
    lateinit var db: AppDatabase
    lateinit var livrosDao: LivrosDao
    var registros: List<Livro> = listOf()
    var posicaoAtual = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_listar)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "banco_pdm.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        livrosDao = db.livrosDao()

        // Carregar os registros do bd
        registros = livrosDao.obterTodosOsLivros()

        // Exibe o primeiro registro na tela (se existir)
        exibirRegistroAtual()

        binding.btnAnterior.setOnClickListener {
            if (posicaoAtual > 0) {
                posicaoAtual--
                exibirRegistroAtual()
            }
        }

        binding.btnProximo.setOnClickListener {
            if (posicaoAtual < registros.size - 1) {
                posicaoAtual++
                exibirRegistroAtual()
            }
        }

    }
    // Exibe o registro atual
    private fun exibirRegistroAtual() {
        if (registros.isNotEmpty()) {
            val livroAtual = registros[posicaoAtual]
            binding.textViewRespTit.text = livroAtual.titulo
            binding.textViewRespAut.text = livroAtual.autor
            binding.textViewRespAno.text = livroAtual.ano.toString()
            binding.textViewRespNota.text = livroAtual.nota.toString()
        } else {
            // Se não tiver registros, limpar os campos
            binding.textViewRespTit.text = ""
            binding.textViewRespAut.text = ""
            binding.textViewRespAno.text = ""
            binding.textViewRespNota.text = ""
        }
    }
}

