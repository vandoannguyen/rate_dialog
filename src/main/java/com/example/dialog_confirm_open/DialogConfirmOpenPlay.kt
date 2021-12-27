package com.example.dialog_confirm_open

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.ratedialog.R
import kotlinx.android.synthetic.main.dialog_confirm_chplay.*

class DialogConfirmOpenPlay(context: Context, private val clickYes: ClickYes) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_confirm_chplay)
        linearYesChPlay.setOnClickListener {
            clickYes.onClick()
            dismiss()
        }
        linearNoChPlay.setOnClickListener {
            dismiss()
        }
    }

    fun interface ClickYes {
        fun onClick()
    }
}