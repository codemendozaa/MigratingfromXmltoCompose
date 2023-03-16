package com.example.migratingfromxmltocompose

sealed interface ForSaleState {
    data class DataReady(val list: List<ForSaleItem>) : ForSaleState

    object Loading : ForSaleState
}