package com.example.bottomsheetcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomsheetcomponent.databinding.FragmentNewBottomSheetDialogBinding

class NewBottomSheetDialogFragment(
    isFullscreen: Boolean = false
) : CustomBottomSheetDialogFragment(isFullscreen) {
    private lateinit var binding: FragmentNewBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBottomSheetDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        const val TAG = "NewBottomSheetDialogFragment"
    }
}