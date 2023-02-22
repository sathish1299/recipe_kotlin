package com.example.tracking.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.immortal.views.base.MyBaseFragment
import com.example.tracking.Constants
import com.example.tracking.R
import com.example.tracking.databinding.FragmentHomeBinding
import com.example.tracking.helpers.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : MyBaseFragment(R.layout.fragment_home) {

    val binding by viewBinding (FragmentHomeBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onErrorCalled(it: String?) {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
    fun initViews(){

        binding.addBtn.setOnClickListener{
            val expenses = binding.expensesET.text.toString()
            val amount = binding.amountET.text.toString()
            val intent = Intent(context,ViewActivity::class.java)
            intent.putExtra("data",expenses)
            intent.putExtra("rupees",amount)
            getSharedPrefManager().setPreference(Constants.DATA,expenses)
            getSharedPrefManager().setPreference(Constants.AMOUNT,amount)
            startActivity(intent)
        }
        val budget = getSharedPrefManager().getPreference(Constants.BUDGET)
        if(budget != null){
            binding.monthsNOTV.text = budget.toString()
        }else{
            binding.monthsNOTV.text = "Budget not selected"
        }


    }
}