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

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    fun isdigit(input: EditText): Boolean {
        val data = input.text.toString().trim { it <= ' ' }
        for (element in data) {
            if (!Character.isDigit(element)) return false
        }
        return true
    }

    fun ischar(input: EditText): Boolean {
        val data = input.text.toString().trim { it <= ' ' }
        for (element in data) {
            if (!Character.isDigit(element)) return true
        }
        return false
    }

}