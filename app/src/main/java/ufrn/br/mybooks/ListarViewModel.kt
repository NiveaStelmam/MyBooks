package ufrn.br.mybooks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ufrn.br.mybooks.model.Livro


class ListarViewModel : ViewModel() {

    // LiveData para a lista de livros
    private val _livros = MutableLiveData<List<Livro>>()
    val livros: LiveData<List<Livro>>
        get() = _livros

    // Inicialização vazia da lista de livros
    init {
        _livros.value = emptyList()
    }

    // Função para definir a lista de livros
    fun setLivros(livros: List<Livro>) {
        _livros.value = livros
    }
}