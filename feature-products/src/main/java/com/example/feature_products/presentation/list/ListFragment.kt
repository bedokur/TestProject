package com.example.feature_products.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.common.observe
import com.example.feature_products.R
import com.example.feature_products.databinding.FragmentListBinding
import com.example.feature_products.presentation.adapters.ProductsAdapter
import com.example.feature_products.presentation.adapters.decorators.VerticalDecoration
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private val viewBinding by viewBinding(FragmentListBinding::bind)
    private val viewModel: ProductsViewModel by viewModels()
    private val adapter by lazy { ProductsAdapter(viewModel, viewModel::onProductClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.recyclerView.adapter = adapter
        viewBinding.recyclerView.addItemDecoration(VerticalDecoration(4))

        observe(viewModel.productsList) {
            adapter.submitList(it)
        }

        observe(viewModel.errorMessage) {
            Snackbar.make(
                viewBinding.root,
                resources.getText(R.string.on_retry_message),
                Snackbar.LENGTH_SHORT
            ).setAction(resources.getText(R.string.retry_string)) { viewModel.getProducts() }
                .show()
        }
    }
}