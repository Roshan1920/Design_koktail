package com.example.kisan_kalyan_foundation

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class Sign_up : AppCompatActivity() {

    private val pickImageRequestCode = 123
    private lateinit var profilePhotoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val selectDateButton: Button = findViewById(R.id.selectDateButton)
        selectDateButton.setOnClickListener {
            showDatePickerDialog()
        }
        /////////////////////////////////////////////////////////////////////////////////
        //val genderSpinner: Spinner = findViewById(R.id.genderSpinner)

        // Create an ArrayAdapter using the string array and a default spinner layout
//        val genderAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.gender_options,
//            android.R.layout.simple_spinner_item
//        )
//
//        // Specify the layout to use when the list of choices appears
//        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        //genderSpinner.adapter = genderAdapter


        /////////////////////////////////////////////////////////////////////////////////
        // val FieldSpinner: Spinner = findViewById(R.id.FieldSpinner)

//        // Create an ArrayAdapter using the string array and a default spinner layout
//        val FieldAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.field_options,
//            android.R.layout.simple_spinner_item
//        )

        // Specify the layout to use when the list of choices appears
        // FieldAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        //  FieldSpinner.adapter = FieldAdapter

        /////////////////////////////////////////////////////////////////////////////////
        //val titleSpinner: Spinner = findViewById(R.id.titleSpinner)

//        val titleAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.title_options,
//            android.R.layout.simple_spinner_item
//        )

        // titleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //titleSpinner.adapter = titleAdapter

        ///////////////////////////////////////////////////////////////////////////////
        val pickPhotoButton: Button = findViewById(R.id.pickPhotoButton)
        profilePhotoImageView = findViewById(R.id.profilePhoto)

        pickPhotoButton.setOnClickListener {
            // Launch the gallery to pick an image
            val pickPhotoIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickPhotoIntent, pickImageRequestCode)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pickImageRequestCode && resultCode == RESULT_OK && data != null) {
            // Get the selected image URI
            val selectedImageUri: Uri? = data.data

            // Set the selected image to the ImageView
            if (selectedImageUri != null) {
                profilePhotoImageView.setImageURI(selectedImageUri)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish() // This will finish the current activity and go back to the previous one (LoginActivity)
    }

    fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view: DatePicker, yearSelected: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Do something with the selected date
                val selectedDate = "$yearSelected-${monthOfYear + 1}-$dayOfMonth"
                Toast.makeText(this, "Selected Date: $selectedDate", Toast.LENGTH_SHORT).show()
            },
            year,
            month,
            day
        )

        // Set minimum and maximum date if needed
        // datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000 // Set minimum date
        // datePickerDialog.datePicker.maxDate = System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 7) // Set maximum date (7 days from current)

        datePickerDialog.show()
    }

}