package com.example.tictac.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayMap

class GameViewModel:ViewModel(){

    lateinit var cells: ObservableArrayMap<String,String>

    fun init(player1: String, player2:String){

    }

    fun onClickedCellAt( row:Int, column:Int) {

    }
}