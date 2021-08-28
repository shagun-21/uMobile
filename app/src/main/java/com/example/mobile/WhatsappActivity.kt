package com.example.mobile

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_whatsapp.*
import java.net.URLEncoder

class WhatsappActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp)







        btn_send.setOnClickListener {
            val cc:String = country_code_picker.selectedCountryCode.toString()
            val number:String= cc +et_phone_number.text.toString()

            if (et_phone_number.text.isNotEmpty()&&et_msg.text.isNotEmpty()){
                val packagemanager:PackageManager=packageManager
                val i =Intent(Intent.ACTION_VIEW)
                val url="https://api.whatsapp.com/send?phone=" +  number+"&text=" +URLEncoder.encode(et_msg.text.toString(),"UTF-8")
                i.setPackage("com.whatsapp")
                i.data= Uri.parse(url)
                if (i.resolveActivity(packagemanager)!=null){
                    startActivity(i)
                }


            }
            else{
                Toast.makeText(this,"Please enter valid details",Toast.LENGTH_SHORT).show()
            }
        }
    }
}