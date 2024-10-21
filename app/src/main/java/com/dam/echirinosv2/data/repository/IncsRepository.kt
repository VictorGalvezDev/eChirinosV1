package com.dam.echirinosv2.data.repository

import com.dam.echirinosv2.data.model.Incidencia
import com.dam.echirinosv2.data.model.IncsDao

class IncsRepository(private val incsDao: IncsDao) {
    fun getAllIncsByFiltro(idDpto: String, fecha: String, estado: String) =
        incsDao.getAllByFiltro(idDpto, fecha, estado)

    suspend fun insertInc(inc: Incidencia) = incsDao.insert(inc)
    suspend fun updateInc(inc: Incidencia) = incsDao.update(inc)
    suspend fun deleteInc(inc: Incidencia) = incsDao.delete(inc)
}