package dev.pegasus.swipeexoplayer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.pegasus.swipeexoplayer.adapters.PagerAdapterVideo
import dev.pegasus.swipeexoplayer.data.DataSourceVideos
import dev.pegasus.swipeexoplayer.databinding.ActivityMainBinding
import dev.pegasus.swipeexoplayer.entities.ItemVideo

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpEdgeToEdge()

        fetchList()
    }

    private fun setUpEdgeToEdge() {
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewPager)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun fetchList() {
        val list = DataSourceVideos().getList()
        initViewPager(list)
    }

    private fun initViewPager(list: List<ItemVideo>) {
        binding.viewPager.adapter = PagerAdapterVideo(this, list.map { it.videoUrl })
        binding.viewPager.offscreenPageLimit = 1
    }
}