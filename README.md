# Mastering MVVM with Compose: Simple Counter App 🚀
This repository provides a clean, practical example of the Model-View-ViewModel (MVVM) architectural pattern in a modern Android application, built entirely with Jetpack Compose and Kotlin.

The goal is to demonstrate the principles of separation of concerns, lifecycle awareness, and testability using minimal code.

## Key Architectural Concepts Demonstrated
* MVVM Layers: Clear separation between the Model (CounterRepository), ViewModel, and View (CounterScreen).

* State Management: Utilizing Kotlin StateFlow to manage and expose observable UI state.

* Compose Best Practices: Implementing State Hoisting to keep Composables stateless and reusable.

* Lifecycle Safety: Using collectAsStateWithLifecycle() to prevent unnecessary work when the app is in the background.

* Threading: Correct use of Coroutines and viewModelScope for managing background data operations.

<p align="center">
    <img width="250" alt="image" src="https://github.com/user-attachments/assets/1293f3d6-5703-401f-b974-147d29713f48" />
</p>
