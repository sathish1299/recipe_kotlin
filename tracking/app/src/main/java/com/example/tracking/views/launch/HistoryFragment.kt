package com.example.tracking.views.launch

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.immortal.views.base.MyBaseFragment
import com.example.tracking.Constants
import com.example.tracking.ExpensesAdapter
import com.example.tracking.R
import com.example.tracking.data.Expenses
import com.example.tracking.databinding.FragmentHistoryBinding
import com.example.tracking.helpers.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : MyBaseFragment(R.layout.fragment_history) {
val binding by viewBinding (FragmentHistoryBinding::bind)
    var dataList : ArrayList<Expenses>?= ArrayList()
    lateinit var title : Array<String>
    lateinit var amount : Array<String>
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
        binding.addBtn.setOnClickListener{
            val intent = Intent(context,ReportActivity::class.java)
            startActivity(intent)
        }
    }
    fun getData(){
        for(i in title.indices){
            val data = Expenses(title[i],amount[i])
            dataList?.add(data)
        }
        binding.expensesRV.adapter = ExpensesAdapter(dataList!!,requireContext())
    }
    override fun onErrorCalled(it: String?) {
        TODO("Not yet implemented")

    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }

}