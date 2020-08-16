package com.example.viewmodelsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var mutableMessage: MutableLiveData<String> = MutableLiveData("ABC")
    val message: LiveData<String>
        get() = mutableMessage

    private var mutableNavigateNextAction = MutableLiveData<Event<Unit>>()
    val navigateNextAction: LiveData<Event<Unit>>
        get() = mutableNavigateNextAction

    fun reverseMessage() {
        message.value?.let {
            mutableMessage.postValue(it.reversed())
        }
    }

    fun onClickNextButton() {
        mutableNavigateNextAction.postValue(Event(Unit))
    }
}
