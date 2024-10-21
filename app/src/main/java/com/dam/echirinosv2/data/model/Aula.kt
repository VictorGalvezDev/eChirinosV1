package com.dam.echirinosv2.data.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "Aulas",
    primaryKeys = ["idDpto", "id"],
    foreignKeys = [
        ForeignKey(
            entity = Departamento::class,
            parentColumns = ["id"],
            childColumns = ["idDpto"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)

data class Aula(
    var idDpto: Int = 0, // PK
    var id: Int = 0, // PK
    var nombre: String = ""
)
