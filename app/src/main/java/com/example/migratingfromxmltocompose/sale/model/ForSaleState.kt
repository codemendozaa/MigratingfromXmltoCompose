package com.example.migratingfromxmltocompose.sale.model

sealed interface ForSaleState {
    data class DataReady(val list: List<ForSaleItem>) : ForSaleState

    object Loading : ForSaleState
}