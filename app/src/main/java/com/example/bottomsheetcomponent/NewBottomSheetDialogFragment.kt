package com.example.bottomsheetcomponent

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomsheetcomponent.databinding.FragmentNewBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class NewBottomSheetDialogFragment(
    val isFullscreen: Boolean = VALUE_FULLSCREEN_DEFAULT,
    override val dimAmount: Float = VALUE_DIM_AMOUNT_DEFAULT
) : CustomBottomSheetDialogFragment(isFullscreen, dimAmount) {
    private lateinit var binding: FragmentNewBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBottomSheetDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun setupBehavior(currentDialog: Dialog) {
        val behavior: BottomSheetBehavior<*> = (currentDialog as BottomSheetDialog).behavior

        if (isFullscreen) {
            behavior.isFitToContents = false
            behavior.halfExpandedRatio = 0.5f
            behavior.peekHeight = 500
            behavior.isHideable = false
            behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        } else {
            behavior.isFitToContents = true
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        setListener(behavior)

        bottomSheetBehavior = behavior
    }

    companion object {
        const val TAG = TAG_BOTTOM_SHEET_DIALOG
    }
}