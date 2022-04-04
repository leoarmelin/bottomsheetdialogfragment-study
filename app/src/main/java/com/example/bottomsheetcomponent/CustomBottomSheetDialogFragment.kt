package com.example.bottomsheetcomponent

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class CustomBottomSheetDialogFragment(
    private val isFullscreen: Boolean = false
) : BottomSheetDialogFragment() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val currentDialog = super.onCreateDialog(savedInstanceState)

        currentDialog.setOnShowListener {
            (view?.parent as ViewGroup).background = ColorDrawable(Color.TRANSPARENT)

            setupBehavior(currentDialog)

            if (isFullscreen) {
                setFullscreen(currentDialog)
            }
        }

        return currentDialog
    }

    private fun setupBehavior(currentDialog: Dialog) {
        val behavior: BottomSheetBehavior<*> = (currentDialog as BottomSheetDialog).behavior

        if (isFullscreen) {
            behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            behavior.isFitToContents = false
            behavior.halfExpandedRatio = 0.5f
            behavior.peekHeight = 200
        } else {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.isFitToContents = true
        }

        setListener(behavior)

        bottomSheetBehavior = behavior
    }

    private fun setListener(behavior: BottomSheetBehavior<*>) {
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> Log.d("Testing", "STATE_EXPANDED")
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> Log.d("Testing", "STATE_HALF_EXPANDED")
                    BottomSheetBehavior.STATE_COLLAPSED -> Log.d("Testing", "STATE_COLLAPSED")
                    BottomSheetBehavior.STATE_DRAGGING -> Log.d("Testing", "STATE_DRAGGING")
                    BottomSheetBehavior.STATE_HIDDEN -> Log.d("Testing", "STATE_HIDDEN")
                    BottomSheetBehavior.STATE_SETTLING -> Log.d("Testing", "STATE_SETTLING")
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

        })
    }

    private fun setFullscreen(currentDialog: Dialog) {
        val mHeight = resources.displayMetrics.heightPixels

        val parentLayout = currentDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val layoutParams = parentLayout.layoutParams
        layoutParams.height = mHeight
        parentLayout.layoutParams = layoutParams
    }
}