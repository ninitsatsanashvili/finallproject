package com.example.finaluri.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finaluri.Fragments.ProfileFragment
import com.example.finaluri.Fragments.QuizFragment


class ViewPagerFragmentAdapter(activity: ProfileFragment): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> QuizFragment()
            1 -> ProfileFragment()
            else -> QuizFragment()

        }
    }
}
