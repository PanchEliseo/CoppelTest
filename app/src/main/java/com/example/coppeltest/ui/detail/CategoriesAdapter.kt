package com.example.coppeltest.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coppeltest.R
import com.example.coppeltest.data.SuperHeroForId
import com.example.coppeltest.databinding.EpoxyItemCategoriesBinding

class CategoriesAdapter(private val superHero: SuperHeroForId): RecyclerView.Adapter<CategoriesAdapter.HeroViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        context = parent.context
        val binding = EpoxyItemCategoriesBinding.inflate(LayoutInflater.from(parent.context))
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.binding.tvIntelligence.text = context.getString(R.string.intelligence, superHero.powerstats!!.intelligence)
        holder.binding.tvStrength.text = context.getString(R.string.strength, superHero.powerstats.strength)
        holder.binding.tvSpeed.text = context.getString(R.string.speed, superHero.powerstats.speed)
        holder.binding.tvDurability.text = context.getString(R.string.durability, superHero.powerstats.durability)
        holder.binding.tvPower.text = context.getString(R.string.power, superHero.powerstats.power)
        holder.binding.tvCombat.text = context.getString(R.string.combat, superHero.powerstats.combat)
        holder.binding.tvFullName.text = context.getString(R.string.full_name, superHero.biography!!.fullName)
        holder.binding.tvAlterEgo.text = context.getString(R.string.alter_ego, superHero.biography.alterEgos)
        holder.binding.tvAlias.text = context.getString(R.string.aliases, superHero.biography.aliases)
        holder.binding.tvPlaceOfBirth.text = context.getString(R.string.place_of_birth, superHero.biography.placeOfBirth)
        holder.binding.tvFirstAppearance.text = context.getString(R.string.first_appearance, superHero.biography.firstAppearance)
        holder.binding.tvPublisher.text = context.getString(R.string.publisher, superHero.biography.publisher)
        holder.binding.tvAlignment.text = context.getString(R.string.alignment, superHero.biography.alignment)
        holder.binding.tvGender.text = context.getString(R.string.gender, superHero.appearance!!.gender)
        holder.binding.tvRace.text = context.getString(R.string.race, superHero.appearance.race)
        holder.binding.tvHeight.text = context.getString(R.string.height, superHero.appearance.height)
        holder.binding.tvWeight.text = context.getString(R.string.weight, superHero.appearance.weight)
        holder.binding.tvEyeColor.text = context.getString(R.string.eye_color, superHero.appearance.eyeColor)
        holder.binding.tvHairColor.text = context.getString(R.string.hair_color, superHero.appearance.hairColor)
        holder.binding.tvOccupation.text = context.getString(R.string.occupation, superHero.work!!.occupation)
        holder.binding.tvBase.text = context.getString(R.string.base, superHero.work.base)
        holder.binding.tvGroupAffiliation.text = context.getString(R.string.group_affiliation, superHero.connections!!.groupAffiliation)
        holder.binding.tvGroupAffiliation.text = context.getString(R.string.relatives, superHero.connections.relatives)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeroViewHolder(val binding: EpoxyItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root)

}