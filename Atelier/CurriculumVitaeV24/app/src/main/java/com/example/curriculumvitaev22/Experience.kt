package com.example.curriculumvitaev22

import androidx.room.*

const val PICTURE = "PICTURE"
const val NAME = "NAME"
const val ADDRESS = "ADDRESS"
const val STARTDATE = "STARTDATE"
const val ENDDATE = "ENDDATE"

@Entity(tableName = "experience")
data class Experience (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "company_pic")
    val companyImage: Int,

    @ColumnInfo(name = "company_name")
    val companyName: String,

    @ColumnInfo(name = "company_address")
    val companyAddress: String,

    @ColumnInfo(name = "start_date")
    val startDate: String,

    @ColumnInfo(name = "end_date")
    val endDate: String,

)