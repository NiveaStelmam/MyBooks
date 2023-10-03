package ufrn.br.mybooks.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ufrn.br.mybooks.model.Livro

@Dao
interface LivrosDao {
    @Insert
    fun inserir(livro: Livro)

    @Query("SELECT * FROM livro")
    fun obterTodosOsLivros(): List<Livro>

}