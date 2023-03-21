package com.example.myapp.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapp.models.UserRepo

@Database(
    entities = [UserRepo::class],
    version = 6
)
abstract class UserRepoDatabase: RoomDatabase() {

    abstract fun userRepoDao(): UserRepoDao

//    val MIGRATION2To3 = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("CREATE TABLE User_Repo(id INTEGER PRIMARY KEY AUTOINCREMENT, userName TEXT NOT NULL, userRepoName TEXT NOT NULL");
//        }
//    }

    companion object {
        @Volatile
        private var instance: UserRepoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context): UserRepoDatabase {

            return Room.databaseBuilder(context.applicationContext,
                UserRepoDatabase::class.java, "UserRepoDB.db")
                .fallbackToDestructiveMigration().build()
        }
    }
}