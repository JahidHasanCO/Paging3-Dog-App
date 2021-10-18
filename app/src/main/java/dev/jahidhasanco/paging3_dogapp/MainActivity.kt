package dev.jahidhasanco.paging3_dogapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.jahidhasanco.paging3_dogapp.data.adapter.DogsAdapter
import dev.jahidhasanco.paging3_dogapp.data.adapter.LoaderStateAdapter
import dev.jahidhasanco.paging3_dogapp.databinding.ActivityMainBinding
import dev.jahidhasanco.paging3_dogapp.ui.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    @Inject
    lateinit var dogsAdapter: DogsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)

        initRecyclerview()
        lifecycleScope.launchWhenStarted {
            mainViewModel.getAllDogs.collectLatest { response->
                binding.apply {
                    progressBar.isVisible=false
                    recyclerview.isVisible=true
                }
                dogsAdapter.submitData(response)
            }
        }
    }

    private fun initRecyclerview() {
        binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@MainActivity,2)
                adapter = dogsAdapter.withLoadStateHeaderAndFooter(
                    header = LoaderStateAdapter { dogsAdapter :: retry},
                    footer = LoaderStateAdapter{dogsAdapter :: retry}
                )
            }
        }
    }
}