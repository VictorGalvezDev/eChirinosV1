package com.dam.echirinosv2.data

import android.content.Context
import com.dam.echirinosv2.data.model.AppDatabase
import com.dam.echirinosv2.data.model.AppDatastore
import com.dam.echirinosv2.data.repository.AulasRepository
import com.dam.echirinosv2.data.repository.DptosRepository
import com.dam.echirinosv2.data.repository.IncsRepository
import com.dam.echirinosv2.data.repository.MainRepository

interface AppContainer {
    val dptosRepository: DptosRepository
    val aulasRepository: AulasRepository
    val incsRepository: IncsRepository
    val mainRepository: MainRepository
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    override val mainRepository: MainRepository by lazy {
        MainRepository(context, AppDatastore.getDataStore(context))
    }

    override val dptosRepository: DptosRepository by lazy {
        DptosRepository(AppDatabase.getDatabase(context).dptoDao())
    }

    override val aulasRepository: AulasRepository by lazy {
        AulasRepository(AppDatabase.getDatabase(context).aulaDao())
    }

    override val incsRepository: IncsRepository by lazy {
        IncsRepository(AppDatabase.getDatabase(context).incsDao())
    }
}