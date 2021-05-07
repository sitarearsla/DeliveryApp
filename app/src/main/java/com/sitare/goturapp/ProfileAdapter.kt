package com.sitare.goturapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sitare.goturapp.databinding.ProfileCardBinding
import com.sitare.goturapp.databinding.ProfileMenuCardBinding

private const val INFO_ITEM: Int = 0
private const val MENU_ITEM: Int = 1


class ProfileAdapter(var mContext: Context, var profileMenuList:List<ProfileMenu>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    inner class ProfileInfoHolder(profileCardBinding: ProfileCardBinding) : RecyclerView.ViewHolder(profileCardBinding.root) {
        var design:ProfileCardBinding
        init {
            this.design = profileCardBinding
        }
    }

    inner class ProfileMenuHolder(menuCardBinding: ProfileMenuCardBinding) : RecyclerView.ViewHolder(menuCardBinding.root) {
        var design:ProfileMenuCardBinding
        init {
            this.design = menuCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        return if (viewType == INFO_ITEM) {
            val design = ProfileCardBinding.inflate(layoutInflater, parent, false)
            ProfileInfoHolder(design)
        } else {
            val design = ProfileMenuCardBinding.inflate(layoutInflater, parent, false)
            ProfileMenuHolder(design)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val menuItem = profileMenuList.get(position)
        if (menuItem.type == INFO_ITEM) {
            (holder as ProfileInfoHolder).design.usernameTextView.text = menuItem.menu_name
            (holder as ProfileInfoHolder).design.userImageView.setImageResource(mContext.resources.getIdentifier(
                    menuItem.menu_icon, "drawable", mContext.packageName
            ))
        } else {
            (holder as ProfileMenuHolder).design.profileMenuTextView.text = menuItem.menu_name
            (holder as ProfileMenuHolder).design.profileMenuImageView.setImageResource(mContext.resources.getIdentifier(
                    menuItem.menu_icon, "drawable", mContext.packageName
            ))
            (holder as ProfileMenuHolder).design.menuCardView.setOnClickListener {
                Snackbar.make(it, "${menuItem.menu_name} clicked", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return profileMenuList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(profileMenuList.get(position).type == 0){
            INFO_ITEM
        } else {
            MENU_ITEM
        }
    }


}