package com.msicoding.learningcoroutine

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SimpleViewModel : ViewModel() {

    private val _textState = MutableStateFlow("")  //this is mutable one, can change
    val textState = _textState.asStateFlow()   // this is immutable , we can't change it but expose it to other

    fun changeText(text: String) {

//        _textState.value = text // can do it this way or update function
        _textState.update { text }

    }

}