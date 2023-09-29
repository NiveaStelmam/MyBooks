package ufrn.br.mybooks.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 data class Livros (
  var nome:String,
  var autor:String,
  var ano:Int,
  var nota:Int,
 ){
  @PrimaryKey(autoGenerate = true)

   var id:Long = 0
 }