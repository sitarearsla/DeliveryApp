package com.sitare.goturapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sitare.goturapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var menuList : ArrayList<ProfileMenu>
    private lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        menuList = ArrayList()
        val m0 = ProfileMenu("Name Lastname", "profile", 0)
        val m1 = ProfileMenu("Addresses", "addresses", 1)
        val m2 = ProfileMenu("Favorite Restaurants", "favorite", 1)
        val m3 = ProfileMenu("Previous Orders", "orders", 1)
        val m4 = ProfileMenu("Payment Methods", "payment", 1)
        val m5 = ProfileMenu("Change Password", "lock", 1)

        menuList.add(m0)
        menuList.add(m1)
        menuList.add(m2)
        menuList.add(m3)
        menuList.add(m4)
        menuList.add(m5)

        adapter = ProfileAdapter(requireContext(), menuList)
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }
}