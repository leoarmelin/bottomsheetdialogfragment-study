package com.example.bottomsheetcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bottomsheetcomponent.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val openBtn: Button = binding.btnActivityMainOpen

        openBtn.setOnClickListener {
            val customBottomSheet = NewBottomSheetDialogFragment(isFullscreen = false)
            customBottomSheet.show(supportFragmentManager, NewBottomSheetDialogFragment.TAG)
        }
    }
}