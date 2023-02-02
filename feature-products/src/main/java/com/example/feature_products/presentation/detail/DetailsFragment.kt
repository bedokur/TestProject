package com.example.feature_products.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.common.observe
import com.example.feature_products.R
import com.example.feature_products.databinding.FragmentDetailsBinding
import com.example.feature_products.presentation.adapters.DetailsImageAdapter
import com.example.feature_products.presentation.adapters.decorators.DotsIndicatorDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val viewModel by viewModels<DetailsViewModel>()
    private val viewBinding by viewBinding(FragmentDetailsBinding::bind)
    private val adapter by lazy { DetailsImageAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.recyclerView.adapter = adapter
        setupDotsDecorator(viewBinding.recyclerView)
        PagerSnapHelper().attachToRecyclerView(viewBinding.recyclerView)

        observe(viewModel.productDetails) {
            adapter.submitList(it.imagesList)
            viewBinding.brand.text = it.brand
            viewBinding.discount.text = getString(R.string.discount, it.discount)
            viewBinding.price.text = getString(R.string.price, it.price)
            viewBinding.description.text = it.description
            viewBinding.title.text = it.title
        }

        observe(viewModel.errorMessage) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            viewModel.navigateBack()
        }
    }

    private fun setupDotsDecorator(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(
            DotsIndicatorDecoration(
                resources.getDimensionPixelSize(R.dimen.dot_radius),
                resources.getDimensionPixelSize(R.dimen.dot_padding),
                resources.getDimensionPixelSize(R.dimen.indicator_height),
                ContextCompat.getColor(requireContext(), R.color.darker_grey),
                ContextCompat.getColor(requireContext(), R.color.light_grey)
            )
        )
    }
}