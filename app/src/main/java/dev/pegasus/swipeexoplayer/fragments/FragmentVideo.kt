package dev.pegasus.swipeexoplayer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dev.pegasus.swipeexoplayer.databinding.FragmentVideoBinding
import dev.pegasus.swipeexoplayer.viewModels.ViewModelMain
import dev.pegasus.swipeexoplayer.viewModels.ViewModelVideo

class FragmentVideo : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ViewModelVideo>()
    private val viewModelMain by activityViewModels<ViewModelMain>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVideoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initExoPlayer()
        initObservers()
    }

    private fun initExoPlayer() {
        val videoUrl = arguments?.getString("video_url") ?: return
        val position = arguments?.getInt("position") ?: return
        val playBackPosition = viewModelMain.getPlaybackPosition(position)

        viewModel.initializePlayer(videoUrl, playBackPosition)
    }

    private fun initObservers() {
        viewModel.isBufferingLiveData.observe(viewLifecycleOwner) { binding.progressBar.isVisible = it }
        viewModel.exoPlayerLiveData.observe(viewLifecycleOwner) { binding.playerView.player = it }
    }

    override fun onResume() {
        super.onResume()
        viewModel.resumePlayer()
    }

    override fun onPause() {
        super.onPause()

        val currentPosition = viewModel.pausePlayer()
        val position = arguments?.getInt("position") ?: return
        viewModelMain.savePlaybackPosition(position, currentPosition) // Save position
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.releasePlayer()
    }

    companion object {
        fun newInstance(videoUrl: String, position: Int) = FragmentVideo().apply {
            arguments = Bundle().apply {
                putString("video_url", videoUrl)
                putInt("position", position)
            }
        }
    }
}