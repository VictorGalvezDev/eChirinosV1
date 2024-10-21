package com.dam.echirinosv2.data.model

import androidx.room.Entity

@Entity(
    tableName = "Departamentos",
    primaryKeys = ["id"]
)
data class Departamento(
    var id: Int = 0,
    var nombre: String = "",
    var clave: String = ""
)
