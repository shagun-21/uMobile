package com.example.mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.list
import java.util.Collections.list
import com.example.mobile.AccountArrayAdapter as AccountArrayAdapter1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupCustomSpinner()

        proceed_btn.setOnClickListener {
            if(et_account_number.text.isNotEmpty()&&et_amount.text.isNotEmpty()){
                Accounts.addToList(et_account_number.text.toString(),et_ifsc_code.text.toString(),et_holder_name.text.toString())
            }
            else{
                Toast.makeText(this,"Please fill the form correctly",Toast.LENGTH_SHORT).show()
            }

        }

        button_whatsapp_activity.setOnClickListener {
            val intent=Intent(this,WhatsappActivity::class.java)
            startActivity(intent)

        }
    }

    private fun setupCustomSpinner() {
        val adapter= AccountArrayAdapter1(this,Accounts.mlist!!)
        custom_spinner.adapter=adapter
    }


}