package com.nermingules.testcase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nermingules.testcase.R
import com.nermingules.testcase.databinding.DialogManualCodeBinding
import com.nermingules.testcase.databinding.FragmentRegisterPlayerBinding

class RegisterPlayerFragment : Fragment() {

    private var _binding: FragmentRegisterPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.qrCodeImage.setImageResource(R.drawable.ic_qr)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnTypeCode.setOnClickListener {
            showManualCodeDialog()
        }
    }

    private fun showManualCodeDialog() {
        val dialogBinding = DialogManualCodeBinding.inflate(layoutInflater)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.dialog_enter_code_title)
            .setView(dialogBinding.root)
            .setPositiveButton(R.string.dialog_enter_code_register) { dialog, _ ->
                val code = dialogBinding.codeInput.text?.toString().orEmpty()
                if (code.isNotEmpty()) {
                    registerPlayer(code)
                }
                dialog.dismiss()
            }
            .setNegativeButton(R.string.dialog_enter_code_cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun registerPlayer(code: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.dialog_registered_title)
            .setMessage(getString(R.string.dialog_registered_message, code))
            .setPositiveButton(R.string.dialog_ok) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

