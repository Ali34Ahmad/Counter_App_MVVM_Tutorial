package com.example.counterappmvvm.data

import kotlinx.coroutines.delay

class CounterRepository {
    private var count = 0

    suspend fun getCount(): Int {
        /**
         * The 'delay' simulates a real-world I/O operation (like a slow API call or database query)
         * to demonstrate the need for coroutines and suspending functions.
         */
        delay(1000)
        return count
    }

    suspend fun incrementCount() {
        /**
         * Simulating the latency involved in a data-modifying network request or transaction.
         * The 'suspend' keyword ensures this operation can run off the main thread.
         */
        delay(1000)
        count++
    }
}