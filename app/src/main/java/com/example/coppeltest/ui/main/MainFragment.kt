package com.example.coppeltest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.coppeltest.MainActivity
import com.example.coppeltest.R
import com.example.coppeltest.databinding.FragmentMainBinding
import com.example.coppeltest.ui.detail.FRAGMENT_LIST_TAG
import com.example.coppeltest.ui.detail.ListHeroFragment


class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        addObservers()
        addView()
        return binding.root
    }

    private fun addView(){
        binding.buttonSearch.setOnClickListener {
            if (binding.editTextId.text.isNotEmpty()) {
                if ((requireActivity() as MainActivity).viewModel.checkForInternet(requireContext())) {
                    if ((requireActivity() as MainActivity).viewModel.isDigit(binding.editTextId))
                        (requireActivity() as MainActivity).viewModel.getHero(binding.editTextId.text.toString())
                    else
                        (requireActivity() as MainActivity).viewModel.getHeroForSearch(binding.editTextId.text.toString())
                } else
                    Toast.makeText(requireContext(), requireActivity().getString(R.string.lost_network), Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(requireContext(), requireActivity().getString(R.string.empty_value), Toast.LENGTH_LONG).show()
        }
    }

    private fun addObservers() {
        (requireActivity() as MainActivity).viewModel.viewState.observe(viewLifecycleOwner) {
            onViewState(it)
        }
    }

    private fun onViewState(state: SearchHeroViewState?) {
        when (state) {
            SearchHeroViewState.ErrorLoadingHero -> {
                binding.loader.visibility = View.GONE
                Toast.makeText(requireContext(), requireActivity().getString(R.string.fail), Toast.LENGTH_LONG).show()
            }
            is SearchHeroViewState.HeroLoaded -> {
                binding.loader.visibility = View.GONE
                (requireActivity() as MainActivity).onRequestChangeFragment(ListHeroFragment.newInstance(state.hero),
                    true,
                    FRAGMENT_LIST_TAG)
            }
            is SearchHeroViewState.Loading -> {
                binding.loader.visibility = View.VISIBLE
            }
            else -> {}
        }
    }

}