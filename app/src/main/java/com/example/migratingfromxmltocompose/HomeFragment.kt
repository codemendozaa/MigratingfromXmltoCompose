package com.example.migratingfromxmltocompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.migratingfromxmltocompose.ForSaleState.DataReady
import com.example.migratingfromxmltocompose.ForSaleState.Loading
import com.example.migratingfromxmltocompose.databinding.FragmentHomeBinding
import com.example.migratingfromxmltocompose.databinding.ViewholderDronItemBinding

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
        binding.recyclerView.adapter = itemsToSaleAdapter
        binding.recyclerView.setHasFixedSize(true)

        viewModel = ViewModelProvider(this).get(ForSaleViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DataReady -> {
//                    binding.progressCircular.visibility = GONE
                    itemsToSaleAdapter.setData(state.list)
                }
                Loading -> {
//                    binding.progressCircular.visibility = VISIBLE
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

sealed interface ForSaleState {
    data class DataReady(val list: List<ForSaleItem>) : ForSaleState

    object Loading : ForSaleState
}

class ItemsToSaleAdapter : ListAdapter<ForSaleItem, ItemToSaleViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemToSaleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_dron_item, parent, false)
        return ItemToSaleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemToSaleViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }

    fun setData(list: List<ForSaleItem>) {
        submitList(list)
    }

    companion object {
        private val diffCallback = object : ItemCallback<ForSaleItem>() {
            override fun areItemsTheSame(oldItem: ForSaleItem, newItem: ForSaleItem): Boolean {
                return oldItem.label == newItem.label
            }

            override fun areContentsTheSame(oldItem: ForSaleItem, newItem: ForSaleItem): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }
}

data class ForSaleItem(
    val label: String,
    val description: String,
    val price: String,
    val itemImage: Int
)

class ItemToSaleViewHolder(view: View) : ViewHolder(view) {

    private lateinit var binding: ViewholderDronItemBinding

    init {
        binding = ViewholderDronItemBinding.bind(view)
    }

    fun bind(item: ForSaleItem) {
        with(binding) {
            textViewLabel.text = item.label
            textViewDescription.text = item.description
            textViewPrice.text = item.price
            appCompatImageView.setBackgroundResource(item.itemImage)
        }
    }

}