package com.example.mobile

data class Account(val accountNumber:String,val ifscCode:String,val holderName:String)
object Accounts{
    private val names= arrayOf("Account Holder Name")
    private val ifsc= arrayOf("IFSC Code")
    private val acc_numbers= arrayOf("Account Number")


    var mlist:ArrayList<Account>?=null
        get(){
            if (field!=null)
                return field

            field=ArrayList()
            for (i in names.indices){
                val name=names[i]
                val ifsc_code=ifsc[i]
                val account_no= acc_numbers[i]

                val account=Account(account_no,ifsc_code,name)
                field!!.add(account)
            }
            return field
        }
   public fun addToList(accNum:String,ifscCode:String,holderName:String){
        val user =Account(accNum,ifscCode,holderName)
        mlist!!.add(user)
    }

}


