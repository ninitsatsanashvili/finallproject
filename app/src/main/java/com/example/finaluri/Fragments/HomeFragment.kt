package com.example.finaluri.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finaluri.R
import com.example.finaluri.RegisterActivity

class HomeFragment : Fragment (R.layout.fragment_home){

    private lateinit var Start : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        Start = view.findViewById(R.id.Start)
        Start.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToQuizFragment()
            navController.navigate(action)
        }
    }
}