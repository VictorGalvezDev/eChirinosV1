package com.dam.echirinosv2.data.model

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "Incidencias",
    primaryKeys = ["idDpto", "fecha", "id"],
    foreignKeys = [
        ForeignKey(
            entity = Departamento::class,
            parentColumns = ["id"],
            childColumns = ["idDpto"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Aula::class,
            parentColumns = ["idDpto", "id"],
            childColumns = ["idDpto", "idAula"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Incidencia(
    var idDpto: Int = 0, // PK
    var fecha: String = "", // PK yyyyMMdd
    var id: String = "",
    var descripcion: String = "",
    var tipo: TipoInc = TipoInc.RMI,
    var idAula: Int? = null,
    var estado: Boolean = false,
    var resolucion: String = ""
)

enum class TipoInc { RMI, RMA }
enum class EstadoInc { RESUELTA, NORESUELTA }


