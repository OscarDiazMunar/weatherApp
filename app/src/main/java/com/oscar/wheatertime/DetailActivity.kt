package com.oscar.wheatertime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oscar.wheatertime.databinding.ActivityDetailBinding
import com.oscar.wheatertime.ui.viewmodels.ForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private val viewModel : ForecastViewModel by viewModel()
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val place = intent.getStringExtra("place")
        viewModel.state.observe(this){
            binding.date0.text = it.forecastUiModel.forecastDay[0].date
            binding.temperature0.text = it.forecastUiModel.forecastDay[0].day.maxtempC.toString() + "ºC"

            binding.date1.text = it.forecastUiModel.forecastDay[1].date
            binding.temperature1.text = it.forecastUiModel.forecastDay[1].day.maxtempC.toString() + "ºC"

            binding.date2.text = it.forecastUiModel.forecastDay[2].date
            binding.temperature2.text = it.forecastUiModel.forecastDay[2].day.maxtempC.toString() + "ºC"
            binding.place.text = place
        }

        viewModel.getForecast(place!!)

    }
}