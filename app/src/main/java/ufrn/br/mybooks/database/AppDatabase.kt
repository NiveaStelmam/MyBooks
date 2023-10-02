package ufrn.br.mybooks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ufrn.br.mybooks.model.Livro
import ufrn.br.mybooks.repository.LivrosDao

@Database(entities = [Livro::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun livrosDao(): LivrosDao
}