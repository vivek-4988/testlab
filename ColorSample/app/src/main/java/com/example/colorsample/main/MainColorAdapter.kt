package com.example.colorsample.network.com.example.sample.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colorsample.R
import com.example.colorsample.dao.PublicAPIItem
import com.example.colorsample.databinding.ItemColorCardBinding
import com.example.colorsample.utils.loadImage

/**
 * RecyclerView Adapter class for displaying color items.
 * This adapter binds color data to the corresponding views.
 */
class MainColorAdapter(
    var list: ArrayList<PublicAPIItem>,
) : RecyclerView.Adapter<MainColorAdapter.ColorHolder>() {

    // Item click listener lambda
    var itemClick: ((PublicAPIItem, Int) -> Unit)? = null

    /**
     * Creates a new ViewHolder instance by inflating the item layout.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        val binding = ItemColorCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ColorHolder(binding)
    }

    /**
     * Binds data to the ViewHolder item views.
     */
    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        val modelObj = list[position]
        holder.bind(modelObj)

        // Set click listener for the item view
        holder.itemView.setOnClickListener {
            itemClick?.invoke(modelObj, position)
        }
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount() = list.size

    /**
     * Returns the view type of the item at the specified position.
     */
    override fun getItemViewType(position: Int): Int {
        return position
    }

    /**
     * Returns the stable item id that represents the given position.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * ViewHolder class for holding and binding color item views.
     */
    inner class ColorHolder(private val binding: ItemColorCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds color data to the item views.
         */
        fun bind(data: PublicAPIItem) {
            try {
                binding.model = data
                binding.executePendingBindings()
                // Load color image using image loading library or method
                binding.imgColor.loadImage(
                    data.imageUrl,
                    error = android.R.drawable.stat_notify_error,
                    placeHolder = R.drawable.ic_launcher_background
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}