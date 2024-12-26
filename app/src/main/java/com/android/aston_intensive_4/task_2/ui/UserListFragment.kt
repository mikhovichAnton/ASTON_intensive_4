package com.android.aston_intensive_4.task_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.aston_intensive_4.databinding.FragmentUserListBinding
import com.android.aston_intensive_4.task_2.adapter.UserAdapter
import com.android.aston_intensive_4.task_2.model.User

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private lateinit var recyclerAdapter: UserAdapter
    private val users = mutableListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onUserItemTouch()
        recyclerInit()
        initUserList()
        onEditedUserParams()
    }

    private fun initUserList() {
        users.add(User("photo_url1", "Pako", "Fahito", "352985328"))
        users.add(User("photo_url2", "Tony", "Jons", "10357325"))
        users.add(User("photo_url3", "Andrey", "Mironov", "3409768346"))
        users.add(User("photo_url4", "Vasiliy", "Paprikov", "4597894"))
        recyclerAdapter.updateUsers(users)
    }


    private fun onUserItemTouch() {
        recyclerAdapter = UserAdapter(users) { user, position ->
            val action =
                UserListFragmentDirections.actionUserListFragmentToEditUserFragment(user, position)
            findNavController().navigate(action)
        }
    }

    private fun onEditedUserParams() {
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<User>("updatedUser")
            ?.observe(viewLifecycleOwner) { updatedUser ->
                val position =
                    findNavController().currentBackStackEntry?.savedStateHandle?.get<Int>("position")
                if (position != null) {
                    users[position] = updatedUser
                    recyclerAdapter.updateUsers(users)
                }
            }
    }

    private fun recyclerInit() {
        with(binding) {
            usersRecycler.layoutManager = LinearLayoutManager(context)
            usersRecycler.adapter = recyclerAdapter
        }

    }
}