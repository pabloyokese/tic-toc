package com.example.tictac.view

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import com.example.tictac.R
import com.example.tictac.viewmodel.GameActivity

class GameBeginDialog: DialogFragment() {
    lateinit var player1Layout: TextInputLayout
    lateinit var player2Layout: TextInputLayout
    lateinit var player1:String
    lateinit var player2:String

    lateinit var player1Edittext: TextInputEditText
    lateinit var player2Edittext: TextInputEditText
    lateinit var activity:GameActivity
    lateinit var rootView:View

    companion object {
        fun newInstance(activity : GameActivity): GameBeginDialog{
            var dialog = GameBeginDialog()
            dialog.activity = activity
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()

        val alertDialog = AlertDialog.Builder(context!!)
            .setView(rootView)
            .setTitle(R.string.game_dialog_title)
            .setCancelable(false)
            .setPositiveButton(R.string.done, null)
            .create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setCancelable(false)
        alertDialog.setOnShowListener { dialog -> onDialogShow(alertDialog) }

        return super.onCreateDialog(savedInstanceState)
    }


    private fun onDialogShow(dialog: AlertDialog) {
        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener { v -> onDoneClicked() }
    }

    private fun onDoneClicked() {
        if (isAValidName(player1Layout, player1) and isAValidName(player2Layout, player2)) {
//            activity.onPlayersSet(player1, player2)
            dismiss()
        }
    }


    private fun isAValidName(layout: TextInputLayout, name: String): Boolean {
//        if (TextUtils.isEmpty(name)) {
//            layout.isErrorEnabled = true
//            layout.error = getString(R.string.game_dialog_empty_name)
//            return false
//        }
//
//        if (player1 != null && player2 != null && player1.equals(player2, ignoreCase = true)) {
//            layout.isErrorEnabled = true
//            layout.error = getString(R.string.game_dialog_same_names)
//            return false
//        }
//        val equals = player1.equals(player2, ignoreCase = true)
//        layout.isErrorEnabled = false
        layout.error = ""
        return true
    }

    fun initViews(){
        rootView =LayoutInflater.from(context).inflate(R.layout.game_begin_dialog,null,false)
        player1Layout =rootView.findViewById(R.id.layout_player1)
        player2Layout =rootView.findViewById(R.id.layout_player2)

        player1Edittext = rootView.findViewById(R.id.et_player1)
        player2Edittext = rootView.findViewById(R.id.et_player2)
        addTextWatchers()
    }

    fun addTextWatchers(){
        player1Edittext.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                player1 =s.toString()
            }
        })

        player2Edittext.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                player2 =s.toString()
            }
        })
    }
}