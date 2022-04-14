package com.example.coppeltest.ui.detail

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coppeltest.R
import com.example.coppeltest.data.SuperHeroForId
import com.example.coppeltest.databinding.EpoxyItemHeroDetailBinding

class HeroAdapter(private val list: List<SuperHeroForId>): RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    private lateinit var context: Context

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?){
            Glide.with(view.context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        context = parent.context
        val binding = EpoxyItemHeroDetailBinding.inflate(LayoutInflater.from(parent.context))
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {

        with(list[position]) {
            val adapterCategories = CategoriesAdapter(this)
            holder.binding.expandedView.adapter = adapterCategories
            holder.binding.textViewName.text = this.name
            //holder.binding.hero = this
            downLoadImage(this.image?.url!!, holder.binding.imageViewHero)
            holder.binding.headerHero.setOnClickListener {
                this.expanded = !this.expanded
                notifyDataSetChanged()
            }
            if (expanded)
                holder.binding.expandedView.visibility = View.VISIBLE
            else
                holder.binding.expandedView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun downLoadImage(imgUrl: String, imgView: ImageView) {
        Glide.with(context)
            .load(imgUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(imgView)
    }

    class HeroViewHolder(val binding: EpoxyItemHeroDetailBinding) : RecyclerView.ViewHolder(binding.root)

}