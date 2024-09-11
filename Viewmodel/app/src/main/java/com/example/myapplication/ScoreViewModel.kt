package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    private var _scoreOne=MutableLiveData<Int>()
    val scoreOne:MutableLiveData<Int> get() = _scoreOne
    private var _scoreTwo=MutableLiveData<Int>()
    val scoreTwo:MutableLiveData<Int> get() = _scoreTwo
    fun incrementTeamOneScore(){
        val curentScore = _scoreOne.value?:0
        _scoreOne.value = curentScore+1
    }
    fun incrementTeamTwoScore(){
        val curentScore = _scoreTwo.value?:0
        _scoreTwo.value = curentScore+1
    }
}