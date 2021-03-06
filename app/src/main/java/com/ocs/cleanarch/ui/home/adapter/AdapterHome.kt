package com.ocs.cleanarch.ui.home.adapter

import android.databinding.DataBindingUtil
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import com.ocs.cleanarch.R
import com.ocs.cleanarch.databinding.ItemHomeListBinding
import com.ocs.cleanarch.ui.base.BaseActivity
import com.ocs.cleanarch.utils.TempImages
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created on 19/5/18.
 */

class AdapterHome(private val activity: BaseActivity) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    lateinit var images: ArrayList<String>


    fun setImages(imagesArray: Array<String>) {
        images = ArrayList();
        images.addAll(imagesArray.asList())
        Log.d("images____", images.toString())
        notifyDataSetChanged()
    }

    fun shuffle() {
        images.shuffle()
        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeListBinding>(LayoutInflater.from(activity), R.layout.item_home_list, null, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(var binding: ItemHomeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            activity.loadImage(binding.ivItemHomeImage, TempImages.images.get(position))
        }
    }
}
