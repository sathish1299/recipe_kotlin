package com.example.tracking.views.launch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.Pair
import com.app.immortal.views.base.MyBaseFragment
import com.example.tracking.Constants
import com.example.tracking.R
import com.example.tracking.databinding.FragmentSettingsBinding
import com.example.tracking.helpers.DateHelper
import com.example.tracking.helpers.viewBinding
import com.google.android.material.datepicker.MaterialDatePicker

class SettingsFragment : MyBaseFragment(R.layout.fragment_settings) {
    val binding by viewBinding (FragmentSettingsBinding::bind)

    override fun onErrorCalled(it: String?) {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    fun initViews(){
        val dateRangePicker =
            MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select dates")
                .setSelection(
                    Pair(
                        MaterialDatePicker.thisMonthInUtcMilliseconds(),
                        MaterialDatePicker.todayInUtcMilliseconds()
                    )

                )
                .setTheme(R.style.ThemeOverlay_App_DatePicker)
                .build()

        binding.budgeBtn.setOnClickListener{
            dateRangePicker.show(requireFragmentManager(),"startDatePicker")
        }
        dateRangePicker.addOnPositiveButtonClickListener {
            val  startDate= DateHelper.getMilliSecondT0DateFormat(it.first)
            val endDate = DateHelper.getMilliSecondT0DateFormat(it.second)
            binding.monthsNOTV.setText("$startDate - $endDate")
        }
        binding.saveBtn.setOnClickListener {
            val budget = binding.amountNoET.text.toString()
            getSharedPrefManager().setPreference(Constants.BUDGET,budget)
            Toast.makeText(context,"Budget Saved",Toast.LENGTH_LONG).show()
        }
    }


}