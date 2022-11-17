package com.example.blooddonor.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blooddonor.databinding.ItemSeekersBinding

class SeekersAdapter() : RecyclerView.Adapter<SeekersAdapter.Myviewholder>() {

    class Myviewholder(val binding: ItemSeekersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {

        return Myviewholder(
            ItemSeekersBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 10
    }

}