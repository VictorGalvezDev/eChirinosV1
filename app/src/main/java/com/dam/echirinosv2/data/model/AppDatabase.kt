package com.dam.echirinosv2.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dam.echirinosv2.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@Database(
    entities = [Departamento::class, Aula::class, Incidencia::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dptoDao(): DptoDao
    abstract fun aulaDao(): AulaDao
    abstract fun incsDao(): IncsDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    context.getString(R.string.value_pref_dbname)
                )
                    .addCallback(DBCallback())
                    .build()
                    .also { Instance = it }
            }
        }
    }

    private class DBCallback : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Instance?.let { database ->
                val scope = MainScope()
                scope.launch {
                    val dao = database.dptoDao()
                    val dpto = Departamento(0, "admin", "a")
                    dao.insert(dpto)
                }
            }
        }
    }
}
