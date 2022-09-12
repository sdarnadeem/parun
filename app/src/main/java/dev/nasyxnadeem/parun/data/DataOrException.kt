package dev.nasyxnadeem.parun.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf



data class DataOrException<T, Boolean, E: Exception>(
    val data: MutableState<T?> = mutableStateOf(null),
    val loading: MutableState<Boolean?> = mutableStateOf(null),
    val e : MutableState<E?> = mutableStateOf(null),
    val message: MutableState<String?> = mutableStateOf(null)

)
