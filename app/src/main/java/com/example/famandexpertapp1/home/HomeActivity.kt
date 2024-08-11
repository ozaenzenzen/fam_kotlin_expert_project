package com.example.famandexpertapp1.home

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.databinding.ActivityHomeBinding
import com.example.famandexpertapp1.favorite.FavoriteActivity
import com.example.famandexpertapp1.welcome.MainActivity
import com.example.famandexpertapp1.welcome.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar("Home Page")
    }

    private fun setToolbar(title: String) {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            // setDisplayHomeAsUpEnabled(true)
//            setBackgroundDrawable(ColorDrawable(Color.parseColor("#161B22")))
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
                Intent(this@HomeActivity, FavoriteActivity::class.java).also { it ->
                    startActivity(it)
                }
                return true
            }

            R.id.logout -> {
                homeViewModel.removeToken()
                Intent(this@HomeActivity, MainActivity::class.java).also { it ->
                    startActivity(it)
                    finish()
                }
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}