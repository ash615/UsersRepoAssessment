package com.example.myapp.repository

import com.example.myapp.db.UserRepoDatabase
import com.example.myapp.models.UserRepo

class UserDataRepository(private val db: UserRepoDatabase) {

    suspend fun insert(userRepo: UserRepo) = db.userRepoDao().insertRepo(userRepo)

    fun getAllUsersRepo() = db.userRepoDao().getUserRepos()

}