package com.example.coppeltest.ui.main

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coppeltest.data.SuperHeroForId
import com.example.coppeltest.repository.SuperHeroRepository
import kotlinx.coroutines.launch

class SuperHeroViewModel: ViewModel() {

    val viewState = MutableLiveData<SearchHeroViewState>()

    fun getHero(id: String) = viewModelScope.launch {
        viewState.value = SearchHeroViewState.Loading
        val response = SuperHeroRepository.getSuperHero(id)
        if (response.isSuccessful)
            viewState.value = SearchHeroViewState.HeroLoaded(arrayListOf(response.body()!!))
        else
            viewState.value = SearchHeroViewState.ErrorLoadingHero
    }

    fun getHeroForSearch(name: String) = viewModelScope.launch {
        viewState.value = SearchHeroViewState.Loading
        val response = SuperHeroRepository.getSuperHeroForSearch(name)
        if (response.isSuccessful)
            viewState.value = response.body()?.let { SearchHeroViewState.HeroLoaded(it.results as ArrayList<SuperHeroForId>) }
        else
            viewState.value = SearchHeroViewState.ErrorLoadingHero
    }

    fun checkForInternet(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    fun isDigit(input: EditText): Boolean {
        val data = input.text.toString().trim { it <= ' ' }
        for (element in data) {
            if (!Character.isDigit(element)) return false
        }
        return true
    }

}