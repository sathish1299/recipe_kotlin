package com.example.tracking.views.launch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.immortal.views.base.MyBaseFragment
import com.example.tracking.Constants
import com.example.tracking.ExpensesAdapter
import com.example.tracking.R
import com.example.tracking.TotalExpensesAdapter
import com.example.tracking.data.Expenses
import com.example.tracking.databinding.ActivityReportBinding
import com.example.tracking.helpers.viewBinding


class ReportActivity : AppCompatActivity() {
    // TODO: Rename and change types of parameters

    val binding by viewBinding(ActivityReportBinding::inflate)
    var dataList : ArrayList<Expenses>?= ArrayList()
    lateinit var title : Array<String>
    lateinit var amount : Array<String>
    val sharedPrefManager: com.example.tracking.manager.SharedPrefManager
        get() {
            return com.example.tracking.manager.SharedPrefManager.getInstance(this)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val titles = sharedPrefManager.getPreference(Constants.DATA)
        val amounts = sharedPrefManager.getPreference(Constants.AMOUNT)
        title = arrayOf("HouseLoan","Groceries","Current Bill",titles!!)
        amount = arrayOf("2000","3000","4000",amounts!!)
        initViews()

    }
    fun initViews(){
        binding.totalExpensesRV.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        getData()
    }
    fun getData(){
        for(i in title.indices){
            val data = Expenses(title[i],amount[i])
            dataList?.add(data)
        }
        binding.totalExpensesRV.adapter = TotalExpensesAdapter(dataList!!,this)
    }

}