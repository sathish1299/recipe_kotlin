package com.example.tracking.views

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tracking.ExpensesAdapter
import com.example.tracking.R
import com.example.tracking.data.Expenses
import com.example.tracking.databinding.ActivityViewBinding
import com.example.tracking.helpers.viewBinding

class ViewActivity : AppCompatActivity() {
    val binding by viewBinding(ActivityViewBinding::inflate)
//    var adapter : ExpensesAdapter?=null
    var dataList : ArrayList<Expenses>?= ArrayList()
    lateinit var title : Array<String>
    lateinit var amount : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val titles = intent.getStringExtra("data")
        Log.d(TAG, "onCreate: $titles")
        val amounts = intent.getStringExtra("rupees")
        title = arrayOf("HouseLoan","Groceries","Current Bill",titles!!)
        amount = arrayOf("2000","3000","4000",amounts!!)
        initViews()
    }
    fun initViews(){
        binding.expensesRV.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        getData()
    }
    fun getData(){
        for(i in title.indices){
            val data = Expenses(title[i],amount[i])
            dataList?.add(data)
        }
        binding.expensesRV.adapter = ExpensesAdapter(dataList!!,this)
    }
}