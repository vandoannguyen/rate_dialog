package com.example.dialog_confirm_open

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.example.ratedialog.R
import com.example.ratedialog.databinding.DialogConfirmChplayBinding

class DialogConfirmOpenPlay(context: Context, private val clickYes: ClickYes) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DialogConfirmChplayBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        binding.linearYesChPlay.setOnClickListener {
            clickYes.onClick()
            dismiss()
        }
        binding.linearNoChPlay.setOnClickListener {
            dismiss()
        }
    }

    fun interface ClickYes {
        fun onClick()
    }
}