package com.android.aston_intensive_4.task_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.aston_intensive_4.databinding.FragmentEditUserBinding


class EditUserFragment : Fragment() {

    private lateinit var binding: FragmentEditUserBinding
    private val args: EditUserFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = args.user
        val position = args.position

        with(binding) {
            editTextFirstN.setText(user.firstName)
            editTextLastN.setText(user.lastName)
            editTextPhone.setText(user.phoneNumber)

            buttonSave.setOnClickListener {
                user.firstName = editTextFirstN.text.toString()
                user.lastName = editTextLastN.text.toString()
                user.phoneNumber = editTextPhone.text.toString()

                findNavController().previousBackStackEntry?.savedStateHandle?.set("updatedUser", user)
                findNavController().previousBackStackEntry?.savedStateHandle?.set("position", position)
                findNavController().navigateUp()
            }
        }
    }
}