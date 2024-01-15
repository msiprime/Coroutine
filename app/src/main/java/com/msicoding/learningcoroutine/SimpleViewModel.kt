package com.msicoding.learningcoroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimpleViewModel : ViewModel() {

    private val _textState = MutableStateFlow("")  //this is mutable one, can change
    val textState =
        _textState.asStateFlow()   // this is immutable , we can't change it but expose it to other

    private val _sharedFow = MutableSharedFlow<Boolean>()
    val sharedFlow = _sharedFow.asSharedFlow()

    private val _channel = Channel<Boolean>()
    val channelFlow = _channel.receiveAsFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            _sharedFow.emit(true)
        }
    }

    fun changeText(text: String) {

//        _textState.value = text // can do it this way or update function
        _textState.update { text }

    }

}