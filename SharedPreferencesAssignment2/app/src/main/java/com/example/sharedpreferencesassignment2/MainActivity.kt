package com.example.sharedpreferencesassignment2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences =getSharedPreferences("INFO", MODE_PRIVATE)

        //Save the data when the button click event happen
        val buttonSaveData =findViewById<Button>(R.id.btnSaveData)
        val buttonLoadData =findViewById<Button>(R.id.btnLoadData)
        val textName =findViewById<TextView>(R.id.txtName)
        val textView =findViewById<TextView>(R.id.txtViewData)

        val boolStatus=findViewById<Switch>(R.id.swtStatus)


        buttonSaveData.setOnClickListener {
            val name = textName.text.toString().trim()
            val married =boolStatus.isChecked

            val editor =sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putBoolean("STATUS",married)
            editor.apply()


        }
        buttonLoadData.setOnClickListener {
            val name = sharedPreferences.getString("NAME","Default")
            val married= sharedPreferences.getBoolean("STATUS",false)
            textView.text="Name :"+name+"Married?"+married

        }




    }
}