package com.example.curriculumvitaev22

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Experience::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun experienceDao(): ExperienceDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: AddExperienceActivity): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "experience")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}

