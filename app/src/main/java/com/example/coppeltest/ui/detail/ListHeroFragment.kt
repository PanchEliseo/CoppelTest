package com.example.coppeltest.ui.detail

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coppeltest.FRAGMENT_TAG
import com.example.coppeltest.MainActivity
import com.example.coppeltest.R
import com.example.coppeltest.data.SuperHeroForId
import com.example.coppeltest.databinding.FragmentListHeroBinding
import com.example.coppeltest.ui.main.MainFragment
import com.example.coppeltest.ui.main.SearchHeroViewState

val FRAGMENT_LIST_TAG = "fragment_service"

class ListHeroFragment: Fragment() {

    private lateinit var binding: FragmentListHeroBinding
    private lateinit var superHero: ArrayList<SuperHeroForId>

    companion object {
        const val HERO = "request_hero"
        fun newInstance(value: ArrayList<SuperHeroForId>): ListHeroFragment {
            val fragment = ListHeroFragment()
            val args = Bundle()
            args.putParcelableArrayList(HERO, value)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.supportFragmentManager?.popBackStack()
                activity?.finish()
                //val fragment = MainFragment.newInstance()
                //(requireActivity() as MainActivity).removeFragment(fragment)
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListHeroBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBundleArgs()
        val adapter = HeroAdapter(superHero)
        binding.recyclerHero.adapter = adapter
    }

    private  fun getBundleArgs() {
        superHero = requireArguments().getParcelableArrayList<SuperHeroForId>(HERO) as ArrayList<SuperHeroForId>
    }

}