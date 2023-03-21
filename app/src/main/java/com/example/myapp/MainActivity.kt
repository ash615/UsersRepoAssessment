package com.example.myapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.adapters.UserRepoAdapter
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.db.UserRepoDatabase
import com.example.myapp.repository.UserDataRepository


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: UserReposViewModel
    private lateinit var repository: UserDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        var btn = findViewById<ImageView>(com.example.myapp.R.id.addUser)
        btn.setOnClickListener {
            val intent = Intent(this, AddRepoActivity::class.java)
            startActivity(intent)
        }

        repository = UserDataRepository(UserRepoDatabase(this));
        val reposViewModelFactory = UserReposViewModelFactory(repository)
        viewModel =
            ViewModelProvider(this, reposViewModelFactory).get(UserReposViewModel::class.java)

        var adapter: UserRepoAdapter

        viewModel.getAllUserReposs().observe(this, Observer {
            adapter = UserRepoAdapter(it, viewModel)
            binding?.rvUsers?.adapter = adapter
            binding?.rvUsers?.layoutManager = LinearLayoutManager(this)
            adapter.items = it
            Log.e("data", it.toString())
            adapter.notifyDataSetChanged()
        })

    }
}