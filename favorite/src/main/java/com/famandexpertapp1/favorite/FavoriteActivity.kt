package com.famandexpertapp1.favorite

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.detail.DetailActivity
import com.example.famandexpertapp1.di.FavoriteModuleDependency
import com.famandexpertapp1.core.ui.FranchiseAdapter
import com.famandexpertapp1.favorite.databinding.ActivityFavoriteBinding
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFavoriteBinding

    private lateinit var franchiseAdapter: FranchiseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependency::class.java
                )
            )
            .build()
            .inject(this)


        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar(getString(R.string.title_favorite_page))
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
            intent.putExtra(
                "${DetailActivity.EXTRA_DETAIL} FAVORITE",
                selectedData.isFavorite.toString()
            )
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