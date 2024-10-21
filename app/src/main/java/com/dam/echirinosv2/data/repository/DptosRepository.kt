package com.dam.echirinosv2.data.repository

import com.dam.echirinosv2.data.model.Departamento
import com.dam.echirinosv2.data.model.DptoDao
import kotlinx.coroutines.flow.Flow

class DptosRepository(private val dptoDao: DptoDao) {
    fun getAllDptos(): Flow<List<Departamento>> = dptoDao.getAll()
    suspend fun insertDpto(dpto: Departamento) = dptoDao.insert(dpto)
    suspend fun updateDpto(dpto: Departamento) = dptoDao.update(dpto)
    suspend fun deleteDpto(dpto: Departamento) = dptoDao.delete(dpto)

}
