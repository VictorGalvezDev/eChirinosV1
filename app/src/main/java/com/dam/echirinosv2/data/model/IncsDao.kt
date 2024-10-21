package com.dam.echirinosv2.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface IncsDao {

    @Query("SELECT * from Incidencias WHERE idDpto LIKE :idDpto AND fecha >= :fecha AND estado LIKE :estado ORDER BY idDpto,id")
    fun getAllByFiltro(idDpto: String, fecha: String, estado: String): Flow<List<Incidencia>>

    @Insert
    suspend fun insert(inc: Incidencia)

    @Update
    suspend fun update(inc: Incidencia)

    @Delete
    suspend fun delete(inc: Incidencia)
}