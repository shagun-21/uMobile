package com.example.mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_item.view.*

class AccountArrayAdapter(context: Context, accountlist:List<Account>) :ArrayAdapter<Account>(context,0,accountlist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }
    private  fun initView(position: Int, convertView: View?, parent: ViewGroup):View{
        val account=getItem(position)
        val view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        view.acc_no.text=account!!.accountNumber
        view.name.text=account!!.holderName
        view.ifsc.text=account!!.ifscCode
        return view


    }
}