package com.example.codebase.presentation.yourfeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.codebase.R
import com.example.codebase.databinding.FragmentYourFeatureBinding

class YourFeatureFragment : Fragment() {
    private val viewModel: YourFeatureViewModel by viewModels()
    private lateinit var binding: FragmentYourFeatureBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYourFeatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.someFun()
        val recyclerView = binding.rvTest
        recyclerView.adapter = ExampleListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val listOKRs = List<OKRs>()

        binding.buttonSubmitList.setOnClickListener {
            if (listOKRs != null) {
                (recyclerView.adapter as? ListAdapter<OKRs, *>)?.submitList(listOKRs)
            }
        }
    }
}