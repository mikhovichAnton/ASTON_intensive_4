package com.android.aston_intensive_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.aston_intensive_4.databinding.FragmentMainNavBinding
import com.android.aston_intensive_4.task_1.FragmentA


class MainNavFragment : Fragment() {
    private lateinit var binding: FragmentMainNavBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainNavBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonTask1.setOnClickListener {
                buttonTask1.visibility = View.GONE
                buttonTask2.visibility = View.GONE
                if (savedInstanceState == null) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentA())
                        .commit()
                }
            }

            buttonTask2.setOnClickListener {
                buttonTask1.visibility = View.GONE
                buttonTask2.visibility = View.GONE
                val action = MainNavFragmentDirections.actionMainNavFragmentToUserListFragment()
                view.findNavController().navigate(action)
            }
        }
    }
}