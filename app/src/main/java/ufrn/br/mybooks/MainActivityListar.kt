package ufrn.br.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import ufrn.br.mybooks.database.AppDatabase
import ufrn.br.mybooks.databinding.ActivityListarBinding
import ufrn.br.mybooks.model.Livro
import ufrn.br.mybooks.repository.LivrosDao


class MainActivityListar : AppCompatActivity() {

    lateinit var binding : ActivityListarBinding
    lateinit var viewModel: ListarViewModel
    lateinit var db: AppDatabase
    lateinit var livrosDao: LivrosDao

    var registros: List<Livro> = listOf()
    var posicaoAtual = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_listar)

        viewModel = ViewModelProvider(this).get(ListarViewModel::class.java)
        binding.lifecycleOwner = this


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "banco_pdm.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        livrosDao = db.livrosDao()

        // Carregar os registros do bd
        registros = livrosDao.obterTodosOsLivros()
        viewModel.setLivros(registros)

//        for (livro in registros) {
//            Log.d("teste", "Título: ${livro.titulo}, Autor: ${livro.autor}")
//        }

      // Observa as mudanças na propriedade LiveData "livros" do ViewModel
        viewModel.livros.observe(this, Observer { listaDeLivros ->
            registros = listaDeLivros
            exibirRegistroAtual() // atualiza a interface
        })



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

