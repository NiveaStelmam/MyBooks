package ufrn.br.mybooks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ufrn.br.mybooks.model.Livros
import ufrn.br.mybooks.repository.LivrosDao

@Database(entities = [Livros::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun LivrosDao(): LivrosDao
}