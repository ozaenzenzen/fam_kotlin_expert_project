package com.example.famandexpertapp1.favorite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.databinding.ActivityFavoriteBinding
import com.example.famandexpertapp1.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar("Favorite Page")
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