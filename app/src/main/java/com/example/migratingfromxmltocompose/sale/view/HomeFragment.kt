package com.example.migratingfromxmltocompose.sale.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.migratingfromxmltocompose.compose.ItemsToSaleList
import com.example.migratingfromxmltocompose.sale.model.ForSaleState.DataReady
import com.example.migratingfromxmltocompose.sale.model.ForSaleState.Loading
import com.example.migratingfromxmltocompose.databinding.FragmentHomeBinding
import com.example.migratingfromxmltocompose.sale.viewmodel.ForSaleViewModel

class HomeFragment : Fragment() {

   // private val itemsToSaleAdapter: ItemsToSaleAdapter = ItemsToSaleAdapter()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ForSaleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.recyclerView.apply {
          /* adapter = itemsToSaleAdapter
            setHasFixedSize(true)*/
        }

        viewModel = ViewModelProvider(this).get(ForSaleViewModel::class.java)
        return binding.root
    }

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DataReady -> {
                    binding.recyclerView.setContent {
                        ItemsToSaleList(items = state.list)
                    }
                }
                Loading -> {
                    // Not implemented
                }
            }
        }
        viewModel.loadData()
    }

}

