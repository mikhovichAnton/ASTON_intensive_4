package com.android.aston_intensive_4.task_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aston_intensive_4.R
import com.android.aston_intensive_4.databinding.FragmentCBinding


class FragmentC : Fragment() {

    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val message = arguments?.getString("message")
            textViewMassage.text = message

            toAFragButton.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentA())
                    .disallowAddToBackStack()
                    .commit()
            }

            toDFragButton.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentD())
                    .disallowAddToBackStack()
                    .commit()
            }
        }
    }
}