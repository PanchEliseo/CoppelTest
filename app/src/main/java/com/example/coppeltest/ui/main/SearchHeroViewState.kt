package com.example.coppeltest.ui.main

import com.example.coppeltest.data.SuperHeroForId

sealed interface SearchHeroViewState {
    object Loading: SearchHeroViewState
    object ErrorLoadingHero : SearchHeroViewState
    class HeroLoaded(val hero: ArrayList<SuperHeroForId>) : SearchHeroViewState
}