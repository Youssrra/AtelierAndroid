package com.example.curriculumvitaev22

import androidx.room.*

@Dao
interface ExperienceDao {
    @Insert
    fun insert(champ: Experience)

    @Update
    fun update(champ: Experience)

    @Delete
    fun delete(champ: Experience)

    @Query("SELECT * FROM experience")
    fun getAllExperience(): List<Experience>
}