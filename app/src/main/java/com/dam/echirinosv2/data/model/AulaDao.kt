package com.dam.echirinosv2.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AulaDao {

    @Query("SELECT * from Aulas ORDER BY id,idDpto")
    fun getAll(): Flow<List<Aula>>

    @Query("SELECT * from Aulas WHERE idDpto LIKE :idDpto ORDER BY idDpto,id")
    fun getAllByFiltro(idDpto: String): Flow<List<Aula>>

    @Insert
    suspend fun insert(aula: Aula)

    @Update
    suspend fun update(aula: Aula)

    @Delete
    suspend fun delete(aula: Aula)
}