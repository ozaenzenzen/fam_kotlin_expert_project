package com.example.famandexpertapp1.favorite

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.databinding.ActivityFavoriteBinding
import com.example.famandexpertapp1.detail.DetailActivity
import com.example.famandexpertapp1.home.HomeViewModel
import com.famandexpertapp1.core.ui.FranchiseAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
//    @Inject
//    lateinit var factory: ViewModelFactory
//
//    private val favoriteViewModel: FavoriteViewModel by viewModels {
//        factory
//    }

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private lateinit var binding: ActivityFavoriteBinding

    private lateinit var franchiseAdapter: FranchiseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar("Favorite Page")
        setupAdapter()
        getListFavoriteFranchise()
    }

    private fun getListFavoriteFranchise() {
        lifecycleScope.launch {
            launch {
                favoriteViewModel.getListFavoriteFranchise().collect { result ->
                    if (result != null) {
                        franchiseAdapter.setData(result)

                        with(binding.rvStories) {
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = franchiseAdapter
                        }
                    } else {
                        //
                    }
                }
            }
        }
    }

    private fun setupAdapter() {
        franchiseAdapter = FranchiseAdapter()
        franchiseAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
            intent.putExtra("${DetailActivity.EXTRA_DETAIL} ID", selectedData.games[0].toString())
            intent.putExtra("${DetailActivity.EXTRA_DETAIL} IMAGE", selectedData.image.toString())
            intent.putExtra("${DetailActivity.EXTRA_DETAIL} FAVORITE", selectedData.isFavorite.toString())
            intent.putExtra("dataFranchise", selectedData)
            startActivity(intent)
        }
    }

    private fun setToolbar(title: String) {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_white_24)
            this.title = title
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}