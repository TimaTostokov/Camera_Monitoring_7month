package com.example.my.camera_monitoring_7month.presentation.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.my.camera_monitoring_7month.presentation.ui.fragments.cameras.CamerasFragment
import com.example.my.camera_monitoring_7month.presentation.ui.fragments.doors.DoorsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CamerasFragment()
            1 -> DoorsFragment()
            else -> CamerasFragment()
        }
    }

}