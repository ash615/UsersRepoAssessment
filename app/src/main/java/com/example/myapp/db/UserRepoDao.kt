package com.example.myapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapp.models.UserRepo

@Dao
interface UserRepoDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepo(repo:UserRepo)

    @Query("SELECT * FROM userrepo")
    fun getUserRepos(): LiveData<List<UserRepo>>
}