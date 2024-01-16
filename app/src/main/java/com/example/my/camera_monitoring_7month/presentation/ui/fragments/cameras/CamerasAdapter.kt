package com.example.my.camera_monitoring_7month.presentation.ui.fragments.cameras

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.example.my.camera_monitoring_7month.databinding.ItemCameraBinding
import com.example.my.camera_monitoring_7month.domain.models.CameraModel

class CamerasAdapter(
) : Adapter<CamerasAdapter.CamerasViewHolder>() {

    private var list: List<CameraModel> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<CameraModel>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamerasViewHolder {
        return CamerasViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CamerasViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class CamerasViewHolder(private val binding: ItemCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(camera: CameraModel) {
            with(binding) {
                ivImage.load(camera.image)
                tvTitle.text = camera.name
                if (camera.rec) {
                    icRec.visibility = View.VISIBLE
                } else {
                    icRec.visibility = View.GONE
                }
                if (camera.favorites) {
                    icStar.visibility = View.VISIBLE
                } else {
                    icStar.visibility = View.GONE
                }
            }
        }
    }

}