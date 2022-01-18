package com.example.finaluri.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.finaluri.R

class StartFragment: Fragment(R.layout.fragment_start), View.OnClickListener {
    var navc: NavController ?= null
    var but: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         navc = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button)?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
    navc?.navigate(R.id.action_homeFragment_to_quizFragment)
    }
}