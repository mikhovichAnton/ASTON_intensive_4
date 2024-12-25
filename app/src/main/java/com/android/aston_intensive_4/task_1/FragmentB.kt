package com.android.aston_intensive_4.task_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aston_intensive_4.R
import com.android.aston_intensive_4.databinding.FragmentBBinding


class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            toAFragButton.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentA())
                    .disallowAddToBackStack()
                    .commit()
            }

            toCFragButton.setOnClickListener {
                val fragmentC = FragmentC()
                val args = Bundle()
                val message = "Hello Fragment C"
                args.putString("message", message)
                fragmentC.arguments = args

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentC)
                    .disallowAddToBackStack()
                    .commit()
            }
        }
    }
}