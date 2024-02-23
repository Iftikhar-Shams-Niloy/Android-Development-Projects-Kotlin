package com.example.myselfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        val contactName = intent.getStringExtra("Contact_Name")
        val contactNumber = intent.getStringExtra("Contact_Number")
        val myDisplayName = intent.getStringExtra("My_Display_Name")
        val includeJunior = intent.getBooleanExtra("Include_Junior", false)
        val jobTitle = intent.getStringExtra("Job_Title")
        val immediateStart = intent.getBooleanExtra("Immediate_Start", false)
        val startDate = intent.getStringExtra("Start_Date")

        val myMessage = "Greetings,\n\n" +
                "I am $contactName. I like to learn and always keep developing myself. I go by the name $myDisplayName.\n\n" +
                "I worked as ${getMyJobTitle(includeJunior,jobTitle.toString())} in a reputed company.\n\n" +
                "I have a portfolio of Android Applications, Web Applications and several Python Projects.\n\n" +
                "If you have a position for me in your company you can contact me by $contactNumber.\n\n" +
                "I prefer to start working from ${getMyStartDate(immediateStart,startDate.toString())}.\n\n" +
                "Best regards,\n\n" +
                "$contactName"

        var textViewMessage : TextView = findViewById(R.id.text_view_message)
        textViewMessage.text = myMessage

        val sendButton = findViewById<Button>(R.id.button_send_message)
        fun setupButton(){
            sendButton.setOnClickListener{
                val myIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto: $contactNumber")
                    putExtra("sms_body", "HELLO THERE")
                }
                startActivity(myIntent)
            }
        }

    }
    fun getMyJobTitle(includeJunior:Boolean, jobTitle:String) = if (includeJunior) "Junior $jobTitle" else jobTitle
    fun getMyStartDate(immediateStart:Boolean, startDate:String) = if(immediateStart) "today" else startDate
}