package com.example.myapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.repository.UserDataRepository

class UserReposViewModelFactory(private val repository: UserDataRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserReposViewModel(repository) as T
    }
}