package com.example.lostandfound

import android.app.Activity
import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AddItemActivity: AppCompatActivity() {

    protected lateinit var itemName: EditText
    protected lateinit var description: EditText
    protected lateinit var dateView:TextView
    protected lateinit var locationView: EditText
    protected lateinit var locationButton: Button
    protected lateinit var dateLostButton: Button
    protected lateinit var submitButton: Button
    protected lateinit var cancelButton: Button

    private lateinit var auth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)

        //findViewById
        itemName = findViewById(R.id.itemName)
        description = findViewById(R.id.description)
//        locationButton = findViewById(R.id.LocationButton)
        dateLostButton = findViewById(R.id.dateLostButton)
        submitButton = findViewById(R.id.submitButton)
        cancelButton = findViewById(R.id.cancelButton)
        locationView = findViewById(R.id.locationView)
        dateView = findViewById(R.id.dateView)

        //onClick listeners for the buttons
//        locationButton.setOnClickListener{
//            Log.i(TAG,"locationButton clicked")
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194"))
//            startActivity(intent)
//        }
        dateLostButton.setOnClickListener{
            Log.i(TAG,"dateLostButton clicked")
            setDate()
        }

        submitButton.setOnClickListener{
            Log.i(TAG,"submitButton clicked")
//            val intent = Intent(this, LostItemListActivity::class.java)
//            intent.putExtra("item", itemName.text.toString())
//            intent.putExtra("date", dateView.text.toString())
//            intent.putExtra("description", description.text.toString())

            val itemName = itemName.text.toString()
            val itemDate = dateView.text.toString()
            val itemDesc = description.text.toString()
            LostItem.packageIntent(intent, itemName, itemDesc, itemDate)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
        cancelButton.setOnClickListener{
            Log.i(TAG,"cancelButton clicked")
            val intent = null
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
        auth = Firebase.auth


//        if (auth.currentUser != null){
//            finish()
//            startActivity(Intent(this, MainActivity::class.java))
//        }

    }

    private fun setDate() {

        val calendar = Calendar.getInstance()
        val currMonth = calendar[Calendar.MONTH]
        val currDay = calendar[Calendar.DAY_OF_MONTH]
        val currYear = calendar[Calendar.YEAR]

        val datePicker = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { datePicker, currYear, currMonth, currDay ->
                dateView.text = ""+(currMonth+1) + "/" + currDay + "/" + currYear
            }, currYear,currMonth,currDay
        )
        datePicker.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        datePicker.show()
    }


}