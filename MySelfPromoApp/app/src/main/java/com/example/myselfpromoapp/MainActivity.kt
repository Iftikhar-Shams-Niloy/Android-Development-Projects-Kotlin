package com.example.myselfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var contactNameEditText: TextInputEditText // if I don't want it to be null: private var contactNameEditText: TextInputEditText = findViewById(R.id.edit_text_contact_name)
    lateinit var contactNumberEditText: TextInputEditText
    lateinit var myDisplayNameEditText: TextInputEditText
    lateinit var startDateEditText: TextInputEditText
    lateinit var juniorCheckBox: CheckBox
    lateinit var immediateStartCheckBox: CheckBox
    lateinit var jobTitleSpinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewFinder()

        val previewButton = findViewById<Button>(R.id.button_preview)
        previewButton.setOnClickListener{
            onPreviewButtonClicked()
        }
        // Putting spinner Values
        val spinnerValues = arrayOf("Software Developer", "Data Analyst","Data Engineer", "Android Developer", "Android Engineer", "Web Developer", "Web Designer","Full Stack Developer") // val spinnerValues: Array<String> = arrayOf("Hello", "Hi", "Bye Bye")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues) //val spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        jobTitleSpinner?.adapter = spinnerAdapter
    }
    private fun viewFinder(){
        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        juniorCheckBox = findViewById(R.id.check_box_junior)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)
    }
    private fun onPreviewButtonClicked(){
        val contactName = contactNameEditText.text.toString()
        val contactNumber = contactNumberEditText.text.toString()
        val myDisplayName = myDisplayNameEditText.text.toString()
        val includeJunior = juniorCheckBox.isChecked
        val jobTitle = jobTitleSpinner.selectedItem.toString()
        val immediateStart = immediateStartCheckBox.isChecked
        val startDate = startDateEditText.text.toString()

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)

        previewActivityIntent.putExtra("Contact_Name", contactName)
        previewActivityIntent.putExtra("Contact_Number", contactNumber)
        previewActivityIntent.putExtra("My_Display_Name", myDisplayName)
        previewActivityIntent.putExtra("Include_Junior", includeJunior)
        previewActivityIntent.putExtra("Job_Title", jobTitle)
        previewActivityIntent.putExtra("Immediate_Start", immediateStart)
        previewActivityIntent.putExtra("Start_Date", startDate)

        startActivity(previewActivityIntent)
    }
}