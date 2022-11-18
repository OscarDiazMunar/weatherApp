package com.oscar.wheatertime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oscar.wheatertime.databinding.ActivityMainBinding
import com.oscar.wheatertime.ui.screen.SearchAdapter
import com.oscar.wheatertime.ui.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: SearchViewModel by viewModel()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.placesItems.layoutManager = layoutManager
        viewModel.state.observe(this){
            rvAdapter = SearchAdapter(it)
            binding.placesItems.adapter = rvAdapter
            rvAdapter.onItemClick = {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("place", it.name + "-" + it.country)
                }
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        val search = menu?.findItem(R.id.nav_search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = getString(R.string.menu_hint)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText!!)
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }
}