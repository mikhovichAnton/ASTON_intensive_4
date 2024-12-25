package com.android.aston_intensive_4.task_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.aston_intensive_4.R
import com.android.aston_intensive_4.databinding.FragmentABinding


class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToBButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentB())
                .disallowAddToBackStack()
                .commit()
        }
    }
}