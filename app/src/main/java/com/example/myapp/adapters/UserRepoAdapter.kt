package com.example.myapp.adapters

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.MainActivity
import com.example.myapp.R
import com.example.myapp.UserReposViewModel
import com.example.myapp.models.UserRepo

class UserRepoAdapter(
    var items: List<UserRepo>,
    private val viewModel: UserReposViewModel
): RecyclerView.Adapter<UserRepoAdapter.UserRepoViewHolder>() {

    class UserRepoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var userOwner = itemView.findViewById<TextView>(R.id.repoOwner)!!
        var userRepoName= itemView.findViewById<TextView>(R.id.repoName)!!
        var share= itemView.findViewById<ImageView>(R.id.imageView)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.add_repo_preview, parent, false)
        return UserRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: UserRepoViewHolder, position: Int) {
        val currItem = items.get(position)



        if(currItem.userName.isNotEmpty() && currItem.repoName.isNotEmpty()) {
            holder.userOwner.setText(currItem.userName)!!
            holder.userRepoName.setText(currItem.repoName)!!
        }

       holder.share.setOnClickListener {
//           val intent = Intent()
//           val activityy=MainActivity()
//           intent.action = Intent.ACTION_SEND
//           intent.putExtra(Intent.EXTRA_TEXT, currItem.repoName)
//           intent.putExtra(Intent.EXTRA_TEXT, "https://github.com/${currItem.userName}/${currItem.repoName}")
//           intent.type ="plain/text"
//           activityy.startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/${currItem.userName}/${currItem.repoName}")))
       }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}