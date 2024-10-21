package com.dam.echirinosv2.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DptoDao {
    @Query("SELECT * from Departamentos ORDER BY id")
    fun getAll(): Flow<List<Departamento>>

    @Insert
    suspend fun insert(dpto: Departamento)

    @Update
    suspend fun update(dpto: Departamento)

    @Delete
    suspend fun delete(dpto: Departamento)
}
