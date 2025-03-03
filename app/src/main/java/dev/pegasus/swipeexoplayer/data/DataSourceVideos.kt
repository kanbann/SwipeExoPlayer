package dev.pegasus.swipeexoplayer.data

import dev.pegasus.swipeexoplayer.entities.ItemVideo

/**
 * Created by: Sohaib Ahmed
 * Date: 3/3/2025
 *
 * Links:
 * - LinkedIn: https://linkedin.com/in/epegasus
 * - GitHub: https://github.com/epegasus
 */

class DataSourceVideos {

    fun getList(): List<ItemVideo> {
        return listOf(
            ItemVideo(0, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            ItemVideo(1, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            ItemVideo(2, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            ItemVideo(3, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
            ItemVideo(4, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        )
    }
}