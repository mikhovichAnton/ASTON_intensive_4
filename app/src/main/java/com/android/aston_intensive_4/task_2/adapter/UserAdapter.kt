package com.android.aston_intensive_4.task_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.aston_intensive_4.R
import com.android.aston_intensive_4.task_2.model.User

class UserAdapter(private var users: List<User>,
                  private val onClick: (User, Int) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val firstNameTextView: TextView = itemView.findViewById(R.id.first_name)
        private val lastNameTextView: TextView = itemView.findViewById(R.id.last_name)
        private val phoneNumberTextView: TextView = itemView.findViewById(R.id.phone_number)

        fun bind(user: User, position: Int) {
            firstNameTextView.text = user.firstName
            lastNameTextView.text = user.lastName
            phoneNumberTextView.text = user.phoneNumber
            itemView.setOnClickListener { onClick(user, position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position],position)
    }

    override fun getItemCount(): Int = users.size

    fun updateUsers(updateUsers: List<User>){
        users = updateUsers
        notifyDataSetChanged()
    }
}