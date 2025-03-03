package dev.pegasus.swipeexoplayer.viewModels

import androidx.lifecycle.ViewModel

/**
 * Created by: Sohaib Ahmed
 * Date: 3/3/2025
 *
 * Links:
 * - LinkedIn: https://linkedin.com/in/epegasus
 * - GitHub: https://github.com/epegasus
 */

class ViewModelMain : ViewModel() {

    /**
     *  Store position per video
     */
    private val videoStates = mutableMapOf<Int, Long>()

    fun savePlaybackPosition(position: Int, time: Long) {
        videoStates[position] = time
    }

    fun getPlaybackPosition(position: Int): Long {
        return videoStates[position] ?: 0L
    }
}