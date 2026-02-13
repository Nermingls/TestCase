package com.nermingules.testcase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nermingules.testcase.R
import com.nermingules.testcase.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnYes.setOnClickListener {
            findNavController().navigate(
                R.id.action_welcomeFragment_to_registerPlayerFragment
            )
        }

        binding.btnNo.setOnClickListener {
            showDownloadDialog()
        }
    }

    private fun showDownloadDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.dialog_download_title)
            .setMessage(R.string.dialog_download_message)
            .setPositiveButton(R.string.dialog_ok) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

