package com.example.finaluri.Fragments

import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.finaluri.Adapters.ViewPagerFragmentAdapter
import com.example.finaluri.ChangePasswordActivity
import com.example.finaluri.LoginActivity
import com.example.finaluri.R
import com.example.finaluri.UserInfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: ViewPagerFragmentAdapter
    private lateinit var UserName: EditText
    private lateinit var textView: TextView
    private lateinit var Save2: Button
    private lateinit var imageView: ImageView
    private lateinit var editTextUrl: EditText
    private lateinit var ChangePassword: Button
    private lateinit var logOut: Button
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        logOut = view.findViewById(R.id.logOut)
        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val action = ProfileFragmentDirections.actionProfileFragmentToLoginActivity()
            navController.navigate(action)
        }
        ChangePassword = view.findViewById(R.id.ChangePassword)
        ChangePassword.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToChangePasswordActivity()
            navController.navigate(action)
        }

        UserName = view.findViewById(R.id.UserName)
        textView = view.findViewById(R.id.textView)
        Save2 = view.findViewById(R.id.Save2)
        imageView = view.findViewById(R.id.imageView)
        editTextUrl = view.findViewById(R.id.editTextUrl)
        adapter = ViewPagerFragmentAdapter(this)
        registerListeners()




        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo: UserInfo = snapshot.getValue(UserInfo::class.java) ?: return
                Glide.with(this@ProfileFragment)
                    .load(userInfo.imageUrl)
                    .into(imageView)

                textView.text = userInfo.UserName

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun registerListeners() {
        Save2.setOnClickListener {
            val userName: String = UserName.text.toString()
            val url: String = editTextUrl.text.toString()

            val userInfo = UserInfo(userName, url)
            db.child(auth.currentUser?.uid!!).setValue(userInfo)
        }
    }
}
