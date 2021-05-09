package com.sitare.goturapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sitare.goturapp.databinding.CategoryCardBinding

class CategoryAdapter(var mContext: Context, var categoryList: List<Category>) :RecyclerView.Adapter<CategoryAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(categoryCardBinding: CategoryCardBinding):RecyclerView.ViewHolder(categoryCardBinding.root) {
        var design:CategoryCardBinding

        init {
           this.design = categoryCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CategoryCardBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val category = categoryList[position]
        holder.design.categoryTextView.text = category.category_name
        holder.design.categoryImageView.setImageResource(mContext.resources.getIdentifier(
                category.category_image, "drawable", mContext.packageName
        ))

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}