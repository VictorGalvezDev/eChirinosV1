package com.dam.echirinosv2.data.repository

import com.dam.echirinosv2.data.model.Aula
import com.dam.echirinosv2.data.model.AulaDao

class AulasRepository(private val aulaDao: AulaDao) {

    fun getAllAulasByFiltro(idDpto: String) = aulaDao.getAllByFiltro(idDpto)
    suspend fun insertAula(aula: Aula) = aulaDao.insert(aula)
    suspend fun updateAula(aula: Aula) = aulaDao.update(aula)
    suspend fun deleteAula(aula: Aula) = aulaDao.delete(aula)
}