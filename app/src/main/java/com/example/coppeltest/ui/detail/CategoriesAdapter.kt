package com.example.coppeltest.ui.detail

import android.content.Context
import android.util.Log
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
        holder.binding.item = superHero
        /*val intelligence = if (superHero.powerstats?.intelligence.equals("null")) "-" else superHero.powerstats?.intelligence
        holder.binding.tvIntelligence.text = context.getString(R.string.intelligence, intelligence)
        val strength = if (superHero.powerstats?.strength.equals("null")) "-" else superHero.powerstats?.strength
        superHero.powerstats?.strength.let { holder.binding.tvStrength.text = context.getString(R.string.strength, strength) }
        val speed = if (superHero.powerstats?.speed.equals("null")) "-" else superHero.powerstats?.speed
        superHero.powerstats?.speed.let { holder.binding.tvSpeed.text = context.getString(R.string.speed, speed) }
        val durability = if (superHero.powerstats?.durability.equals("null")) "-" else superHero.powerstats?.durability
        superHero.powerstats?.durability.let { holder.binding.tvDurability.text = context.getString(R.string.durability, durability) }
        val power = if (superHero.powerstats?.power.equals("null")) "-" else superHero.powerstats?.power
        superHero.powerstats?.power.let { holder.binding.tvPower.text = context.getString(R.string.power, power) }
        val combat = if (superHero.powerstats?.combat.equals("null")) "-" else superHero.powerstats?.combat
        superHero.powerstats?.combat.let { holder.binding.tvCombat.text = context.getString(R.string.combat, combat) }
        superHero.biography?.fullName.let { holder.binding.tvFullName.text = context.getString(R.string.full_name, superHero.biography?.fullName ?: "-") }
        superHero.biography?.alterEgos.let { holder.binding.tvAlterEgo.text = context.getString(R.string.alter_ego, superHero.biography?.alterEgos ?: "-") }
        superHero.biography?.aliases.let { holder.binding.tvAlias.text = context.getString(R.string.aliases, superHero.biography?.aliases ?: "-") }
        superHero.biography?.placeOfBirth.let { holder.binding.tvPlaceOfBirth.text = context.getString(R.string.place_of_birth, superHero.biography?.placeOfBirth ?: "-") }
        superHero.biography?.firstAppearance.let { holder.binding.tvFirstAppearance.text = context.getString(R.string.first_appearance, superHero.biography?.firstAppearance ?: "-") }
        superHero.biography?.publisher.let { holder.binding.tvPublisher.text = context.getString(R.string.publisher, superHero.biography?.publisher ?: "-") }
        superHero.biography?.alignment.let { holder.binding.tvAlignment.text = context.getString(R.string.alignment, superHero.biography?.alignment ?: "-") }
        superHero.appearance?.gender.let { holder.binding.tvGender.text = context.getString(R.string.gender, superHero.appearance?.gender ?: "-") }
        superHero.appearance?.race.let { holder.binding.tvRace.text = context.getString(R.string.race, superHero.appearance?.race ?: "-") }
        superHero.appearance?.height.let { holder.binding.tvHeight.text = context.getString(R.string.height, superHero.appearance?.height ?: "-") }
        superHero.appearance?.weight.let { holder.binding.tvWeight.text = context.getString(R.string.weight, superHero.appearance?.weight ?: "-") }
        superHero.appearance?.eyeColor.let { holder.binding.tvEyeColor.text = context.getString(R.string.eye_color, superHero.appearance?.eyeColor ?: "-") }
        superHero.appearance?.hairColor.let { holder.binding.tvHairColor.text = context.getString(R.string.hair_color, superHero.appearance?.hairColor ?: "-") }
        superHero.work?.occupation.let { holder.binding.tvOccupation.text = context.getString(R.string.occupation, superHero.work?.occupation ?: "-") }
        superHero.work?.base.let { holder.binding.tvBase.text = context.getString(R.string.base, superHero.work?.base ?: "-") }
        superHero.connections?.groupAffiliation.let { holder.binding.tvGroupAffiliation.text = context.getString(R.string.group_affiliation, superHero.connections?.groupAffiliation ?: "-") }
        superHero.connections?.relatives.let { holder.binding.tvGroupAffiliation.text = context.getString(R.string.relatives, superHero.connections?.relatives ?: "-") }*/
    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeroViewHolder(val binding: EpoxyItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root)

}