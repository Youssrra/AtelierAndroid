package com.example.curriculumvitaev22

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker


class AddExperienceActivity : AppCompatActivity() {

    lateinit var dataBase : AppDataBase
    lateinit var recylcerExperience: RecyclerView
    lateinit var recylcerExperienceAdapter: CustomAdapter
    lateinit var experienceList : MutableList<Experience>

    lateinit var image : ImageView
    lateinit var companyName : EditText
    lateinit var companyAddress : EditText
    lateinit var startDate : EditText
    lateinit var endDate : EditText
    lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)

        image = findViewById(R.id.imageViewCompany)
        companyName  = findViewById(R.id.edit_textCompanyName)
        companyAddress = findViewById(R.id.edit_textCompanyAddress)
        startDate = findViewById(R.id.edit_textStartDate)
        endDate = findViewById(R.id.edit_textEndDate)
        btnSave= findViewById(R.id.buttonSave)

        dataBase = AppDataBase.getDatabase(this)

        recylcerExperience.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)


        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()

        //datePicker.show()

        val materialDateBuilder: MaterialDatePicker.Builder<*> =
            MaterialDatePicker.Builder.datePicker()

        materialDateBuilder.setTitleText("SELECT A DATE")
        val materialDatePicker = materialDateBuilder.build()


        startDate.setOnClickListener{
            materialDatePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER");
        }

        materialDatePicker.addOnPositiveButtonClickListener {
            startDate.setText(materialDatePicker.headerText)
        }

        endDate.setOnClickListener{
            materialDatePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER");
        }

        materialDatePicker.addOnPositiveButtonClickListener {
            endDate.setText(materialDatePicker.headerText)
        }


        btnSave.setOnClickListener {
            if (fieldVerification()) {

                var experience : Experience? = null
                experience = Experience(0,image.imageAlpha, companyName.text.toString(),companyAddress.text.toString(),startDate.text.toString(),endDate.text.toString())
                try {
                    dataBase.experienceDao().insert(experience!!)
                    experienceList.add(experience!!)
                    recylcerExperienceAdapter.experienceList = experienceList
                    recylcerExperienceAdapter.notifyDataSetChanged()
                }catch (ex: Exception){
                    Toast.makeText(this, "Could not add the company !",Toast.LENGTH_SHORT).show()
                }

            }else {
                Toast.makeText(this,"Something went wrong please try again ", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun fieldVerification(): Boolean {

        var companyNameError : TextView = findViewById(R.id.textViewCompanyNameError)
        var companyAddressError : TextView = findViewById(R.id.textViewCompanyAddressError)
        var startDateError : TextView = findViewById(R.id.textViewStartDateError)
        var endDateError : TextView = findViewById(R.id.textViewEndDateError)


        if (companyName.length() == 0) {
            companyName.error = "Must not be empty !"
            companyNameError.text = "Must not be empty !"
            return false
        }
        if (companyAddress.length() == 0) {
            companyAddress.error = "Must not be empty !"
            companyAddressError.text = "Must not be empty !"
            return false
        }
        if (startDate.length() == 0) {
            startDate.error = "Must not be empty !"
            startDateError.text = "Must not be empty !"
            return false
        }
        if (endDate.length() == 0) {
            endDate.error = "Must not be empty !"
            endDateError.text = "Must not be empty !"
            return false
        }
        if (image == null){
            Toast.makeText(this,"Please select an image ! ", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }



}