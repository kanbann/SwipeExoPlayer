package dev.pegasus.swipeexoplayer.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

/**
 * Created by: Sohaib Ahmed
 * Date: 3/3/2025
 *
 * Links:
 * - LinkedIn: https://linkedin.com/in/epegasus
 * - GitHub: https://github.com/epegasus
 */

class ViewModelVideo(private val application: Application) : AndroidViewModel(application) {

    private val _exoPlayerLiveData = MutableLiveData<ExoPlayer>()
    val exoPlayerLiveData: LiveData<ExoPlayer> get() = _exoPlayerLiveData

    private var exoPlayer: ExoPlayer? = null

    fun initializePlayer(videoUrl: String, playBackPosition: Long) {
        exoPlayer = ExoPlayer.Builder(application).build().apply {
            setMediaItem(MediaItem.fromUri(videoUrl))
            prepare()
            seekTo(playBackPosition)
            _exoPlayerLiveData.value = this
        }
    }

    fun pausePlayer(): Long {
        exoPlayer?.playWhenReady = false
        return exoPlayer?.contentPosition ?: 0L
    }

    fun resumePlayer() {
        exoPlayer?.playWhenReady = true
    }

    fun releasePlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }

    override fun onCleared() {
        super.onCleared()
        releasePlayer()
    }
}