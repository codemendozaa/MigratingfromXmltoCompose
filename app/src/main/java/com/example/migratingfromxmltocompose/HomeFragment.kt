package com.example.migratingfromxmltocompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.migratingfromxmltocompose.ForSaleState.DataReady
import com.example.migratingfromxmltocompose.ForSaleState.Loading
import com.example.migratingfromxmltocompose.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val itemsToSaleAdapter: ItemsToSaleAdapter = ItemsToSaleAdapter()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ForSaleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.recyclerView.apply {
            adapter = itemsToSaleAdapter
            setHasFixedSize(true)
        }

        viewModel = ViewModelProvider(this).get(ForSaleViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DataReady -> {
                    itemsToSaleAdapter.setData(state.list)
                }
                Loading -> {
                    // Not implemented
                }
            }
        }
        viewModel.loadData()
    }
}

class ForSaleViewModel : ViewModel() {
    private val _state: MutableLiveData<ForSaleState> = MutableLiveData(Loading)
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
        setState(DataReady(list))
    }

    private fun setState(dataReady: ForSaleState) {
        _state.value = dataReady
    }
}