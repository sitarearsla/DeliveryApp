package com.sitare.goturapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sitare.goturapp.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var categoryList : ArrayList<Category>
    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)
        var layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        binding.categoriesRecyclerView.layoutManager = layoutManager


        categoryList = ArrayList()
        val c1 = Category("Yeni Ürünler", "new_products")
        val c2 = Category("İndirimler", "sale")
        val c3 = Category("Damacana", "water")
        val c4 = Category("Su & İçecek", "soft_drink")
        val c5 = Category("Meyve & Sebze", "strawberry")
        val c6 = Category("Fırından", "bread")
        val c7 = Category("Temel Gıda", "pasta")
        val c8 = Category("Atıştırmalık", "chocolate")
        val c9 = Category("Dondurma", "ice_cream")
        val c10 = Category("Yiyecek", "sandwich")
        val c11 = Category("Süt & Kahvaltı", "eggs")
        val c12 = Category("Fit & Form", "fit_form")
        val c13 = Category("Kişisel Bakım", "personal_care")
        val c14 = Category("Ev Bakım", "home_care")
        val c15 = Category("Ev % Yaşam", "lamp")
        val c16 = Category("Teknoloji", "technology")
        val c17 = Category("Evcil Hayvan", "pets")
        val c18 = Category("Bebek", "baby")
        val c19 = Category("Kitap & Dergi", "books")
        val c20 = Category("Giyim", "clothes")

        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c4)
        categoryList.add(c5)
        categoryList.add(c6)
        categoryList.add(c7)
        categoryList.add(c8)
        categoryList.add(c9)
        categoryList.add(c10)
        categoryList.add(c11)
        categoryList.add(c12)
        categoryList.add(c13)
        categoryList.add(c14)
        categoryList.add(c15)
        categoryList.add(c16)
        categoryList.add(c17)
        categoryList.add(c18)
        categoryList.add(c19)
        categoryList.add(c20)

        adapter = CategoryAdapter(requireContext(), categoryList)
        binding.categoriesRecyclerView.adapter = adapter


        return binding.root
    }

}