package com.example.migratingfromxmltocompose.sale.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.migratingfromxmltocompose.R
import com.example.migratingfromxmltocompose.sale.model.ForSaleItem
import com.example.migratingfromxmltocompose.sale.model.ForSaleState

class ForSaleViewModel : ViewModel() {
    private val _state: MutableLiveData<ForSaleState> = MutableLiveData(ForSaleState.Loading)
    val state: LiveData<ForSaleState> = _state

    fun loadData() {
        val list = listOf(
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            ),
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            ),
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            ),
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            ),
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            ),
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            ),
            ForSaleItem(
                "PANTERA 4K",
                "With GPS, WiFi, FPV and Optical \\n Flow Stability",
                "$399.0",
                R.drawable.img_dron_item_home
            )
        )
        setState(ForSaleState.DataReady(list))
    }

    private fun setState(dataReady: ForSaleState) {
        _state.value = dataReady
    }
}