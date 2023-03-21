package com.example.myapp

import androidx.lifecycle.ViewModel
import com.example.myapp.models.UserRepo
import com.example.myapp.repository.UserDataRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class UserReposViewModel(val repository: UserDataRepository): ViewModel() {

    suspend fun insertUserRep(userRepo: UserRepo) = GlobalScope.launch {
            repository.insert(userRepo)
    }

    fun getAllUserReposs() = repository.getAllUsersRepo()
}