package com.example.my.camera_monitoring_7month.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.my.camera_monitoring_7month.R

class CustomItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_door, this, true)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.item_camera, this, true)
    }

}