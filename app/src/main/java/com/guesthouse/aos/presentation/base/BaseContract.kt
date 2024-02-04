package com.guesthouse.aos.presentation.base

import kotlinx.coroutines.flow.StateFlow

interface BaseContract<STATE, EVENT, EFFECT> {
    val state: StateFlow<STATE>
    val effect: StateFlow<EFFECT>
    fun event(event: EVENT)
}