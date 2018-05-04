package com.nektar.appdemo

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.nektar.appdemo.model.User
import kotlinx.android.synthetic.main.include_user_info.view.*
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by Aleksander on 05.05.2018.
 */
class UserAdapter constructor(private val avatarClick: (String) -> Unit, private val itemClick: (User) -> Unit)
    : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val items = ArrayList<User>()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_list)) {

        fun bind(item: User) {
            itemView.userUsername.text = "@${item.username}"
            itemView.userName.text = item.name
            itemView.postTitle.text = item.title.capitalize()
            itemView.postBody.text = item.body.capitalize()
            itemView.userAvatar.setOnClickListener { avatarClick.invoke(item.userId) }
            itemView.setOnClickListener { itemClick.invoke(item) }
        }
    }

    fun addItems(list: List<User>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }
}