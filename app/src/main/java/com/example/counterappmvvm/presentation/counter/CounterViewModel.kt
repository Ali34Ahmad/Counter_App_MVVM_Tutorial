package com.example.counterappmvvm.presentation.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counterappmvvm.data.CounterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterViewModel(
    // NOTE: In production, this would be injected by a DI framework (Hilt/Koin)
    // to decouple the ViewModel from the Repository's creation details.
    private val repository: CounterRepository = CounterRepository()
) : ViewModel() {
    // Internal, mutable StateFlow to update the counter value
    private val _count = MutableStateFlow<Int>(0)

    // Public, immutable StateFlow exposed for the UI to observe changes.
    val count: StateFlow<Int> = _count.asStateFlow()

    init {
        // Initialize the count value when the ViewModel is created
        getCurrentCount()
    }

    fun getCurrentCount() {
        viewModelScope.launch {
            _count.value = repository.getCount()
        }
    }

    // Handles the user action from the View
    fun onIncrementClicked() {
        viewModelScope.launch {
            // 1. Delegate the business logic to the Model
            repository.incrementCount()

            // 2. Update the observable state to notify the View
            _count.value = repository.getCount()
        }
    }
}