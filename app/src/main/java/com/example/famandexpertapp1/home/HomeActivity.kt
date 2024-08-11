package com.example.famandexpertapp1.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.databinding.ActivityHomeBinding
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}