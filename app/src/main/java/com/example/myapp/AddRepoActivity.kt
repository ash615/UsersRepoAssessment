package com.example.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.myapp.databinding.ActivityAddRepoBinding
import com.example.myapp.db.UserRepoDatabase
import com.example.myapp.models.UserRepo
import com.example.myapp.repository.UserDataRepository
import kotlinx.coroutines.launch

class AddRepoActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddRepoBinding
    lateinit var reposViewModel: UserReposViewModel
    lateinit var repository: UserDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRepoBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        repository = UserDataRepository(UserRepoDatabase(this));
        val reposViewModelFactory = UserReposViewModelFactory(repository)
        reposViewModel = ViewModelProvider(this, reposViewModelFactory).get(UserReposViewModel::class.java)


        binding?.add?.setOnClickListener {
            val ownerName = binding?.ownerName?.text.toString()
            val repoName = binding?.repoName?.text.toString()
            if(ownerName.isEmpty() || repoName.isEmpty()){
                Toast.makeText(this,"Please Enter both fields", Toast.LENGTH_LONG).show()
            }

            val user = UserRepo(0, ownerName, repoName)
            lifecycleScope.launch {
                reposViewModel.insertUserRep(user)
               // Toast.makeText(this,"Added Successfully", Toast.LENGTH_LONG).
                binding?.ownerName?.setText("")
                binding?.repoName?.setText("")
            }

        }
    }
}