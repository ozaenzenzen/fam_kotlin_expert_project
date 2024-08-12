package com.example.famandexpertapp1.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.famandexpertapp1.BuildConfig.ACCESS_CLIENT_ID
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.databinding.ActivityHomeBinding
import com.example.famandexpertapp1.detail.DetailActivity
import com.example.famandexpertapp1.favorite.FavoriteActivity
import com.example.famandexpertapp1.welcome.MainActivity
import com.famandexpertapp1.core.ui.FranchiseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
//    @Inject
//    lateinit var factory: ViewModelFactory
//
//    private val homeViewModel: HomeViewModel by viewModels {
//        factory
//    }

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding

    private lateinit var franchiseAdapter: FranchiseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar("Home Page")
        setupAdapter()
        getDataList()
    }

    private fun setupAdapter() {
        franchiseAdapter = FranchiseAdapter()
        franchiseAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@HomeActivity, DetailActivity::class.java)
//            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
    }

    private fun getDataList() {
        homeViewModel.getToken().observe(this) { valueToken ->
            homeViewModel.dataList(
                clientID = ACCESS_CLIENT_ID,
                token = "Bearer $valueToken",
            ).observe(this) { franchise ->
                Log.d("home view", "${franchise}")
                if (franchise != null) {
                    when (franchise) {
                        is com.famandexpertapp1.core.data.Resource.Loading -> binding.viewLoading.visibility =
                            View.VISIBLE

                        is com.famandexpertapp1.core.data.Resource.Success -> {
                            binding.viewLoading.visibility = View.GONE

                            binding.tvNotFoundError.visibility = View.GONE
                            binding.ivNotFoundError.visibility = View.GONE

                            franchiseAdapter.setData(franchise.data)
                        }

                        is com.famandexpertapp1.core.data.Resource.Error -> {
                            binding.viewLoading.visibility = View.GONE

                            binding.tvNotFoundError.visibility = View.VISIBLE
                            binding.ivNotFoundError.visibility = View.VISIBLE

                            binding.tvNotFoundError.text = getString(R.string.something_wrong)
                        }
                    }
                } else {
                    binding.viewLoading.visibility = View.GONE

                    binding.tvNotFoundError.visibility = View.VISIBLE
                    binding.ivNotFoundError.visibility = View.VISIBLE

                    binding.tvNotFoundError.text = getString(R.string.something_wrong)
                }
            }
            with(binding.rvStories) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = franchiseAdapter
            }
        }

    }

    private fun setToolbar(title: String) {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            // setDisplayHomeAsUpEnabled(true)
            this.title = title
        }
        val drawable = binding.toolbar.toolbar.overflowIcon
        drawable?.setTint(ContextCompat.getColor(this, R.color.white))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorites -> {
                Intent(this@HomeActivity, FavoriteActivity::class.java).also {
                    startActivity(it)
                }
                return true
            }

            R.id.logout -> {
                homeViewModel.removeToken()
                Intent(this@HomeActivity, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}