package com.example.tracking.views.launch

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.immortal.views.base.MyBaseFragment
import com.example.tracking.*
import com.example.tracking.data.Expenses
import com.example.tracking.databinding.FragmentRemainderBinding
import com.example.tracking.helpers.viewBinding


class RemainderFragment : MyBaseFragment(R.layout.fragment_remainder) {
    val binding by viewBinding (FragmentRemainderBinding::bind)
    var dataList : ArrayList<Expenses>?= ArrayList()
    lateinit var title : Array<String>
    lateinit var amount : Array<String>
    override fun onErrorCalled(it: String?) {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val titles = getSharedPrefManager().getPreference(Constants.DATA)
        val amounts = getSharedPrefManager().getPreference(Constants.AMOUNT)
        title = arrayOf("HouseLoan","Groceries","Current Bill",titles!!)
        amount = arrayOf("2000","3000","4000",amounts!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    fun initViews(){
        binding.expensesRV.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        getData()

    }
    fun getData(){
        for(i in title.indices){
            val data = Expenses(title[i],amount[i])
            dataList?.add(data)
        }
        binding.expensesRV.adapter = ReminderAdapter(dataList!!,requireContext())
    }
}