package com.example.famandexpertapp1.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.famandexpertapp1.BuildConfig.ACCESS_CLIENT_ID
import com.example.famandexpertapp1.R
import com.example.famandexpertapp1.databinding.ActivityDetailBinding
import com.example.famandexpertapp1.favorite.FavoriteViewModel
import com.example.famandexpertapp1.welcome.MainViewModel
import com.famandexpertapp1.core.data.Resource
import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
//    @Inject
//    lateinit var factory: ViewModelFactory
//
//    private val detailViewModel: DetailViewModel by viewModels {
//        factory
//    }

    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    private lateinit var detailGamesData: List<Games>

//    private var idGames: String? = null

    private var idGames: String? = null
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idGames = intent.extras?.get("${EXTRA_DETAIL} ID") as String
        imageUrl = intent.extras?.get("${EXTRA_DETAIL} IMAGE") as String

        setToolbar("Detail Page")
        getDetailData()
    }

    private fun getDetailData() {
        lifecycleScope.launch {
            detailViewModel.getToken().collect { valueToken ->
                if (valueToken != null || valueToken != "") {
                    detailViewModel.dataDetail(
                        clientID = ACCESS_CLIENT_ID,
                        token = "Bearer $valueToken",
                        gamesID = idGames,
                    ).collect { dataDetail ->
                        when (dataDetail) {
                            is Resource.Loading -> {
                                binding.viewLoading.visibility =
                                    View.VISIBLE
                            }

                            is Resource.Success -> {
                                binding.viewLoading.visibility = View.GONE

                                binding.tvNotFoundError.visibility = View.GONE
                                binding.ivNotFoundError.visibility = View.GONE

                                Log.d("idGames1", "${idGames}")
                                Log.d("outputs1", "${dataDetail.data!![0].name}")
                                Log.d("outputs2", "${dataDetail.data!![0].id}")

                                detailGamesData = dataDetail.data!!
                                setData(detailGamesData[0])
                            }

                            is Resource.Error -> {
                                binding.viewLoading.visibility = View.GONE

                                binding.tvNotFoundError.visibility = View.VISIBLE
                                binding.ivNotFoundError.visibility = View.VISIBLE

                                binding.tvNotFoundError.text = getString(R.string.something_wrong)
                            }
                        }

                    }
                } else {
                    // Failed get token
                }
            }
        }
    }

    private fun setData(games: Games) {
        binding.apply {
            Glide
                .with(this@DetailActivity)
                .load(imageUrl.toString())
                .placeholder(R.drawable.image_item)
                .into(ivDetailPhoto)
            tvDetailName.text = games.name
            tvDetailDescription.text = games.summary
        }
    }

    private fun setToolbar(title: String) {
        setSupportActionBar(binding.toolbarDetail.toolbar)
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

    companion object {
        const val EXTRA_DETAIL = "DetailActivity"
    }
}