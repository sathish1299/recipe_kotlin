package com.example.tracking.views.launch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.immortal.views.base.MyBaseFragment
import com.example.tracking.R
import com.example.tracking.databinding.FragmentSettingsBinding
import com.example.tracking.helpers.viewBinding

class SettingsFragment : MyBaseFragment(R.layout.fragment_home) {
    val binding by viewBinding (FragmentSettingsBinding::bind)
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
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
    }


}