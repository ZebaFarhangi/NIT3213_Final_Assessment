package com.example.androidappdev.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidappdev.R
import com.example.androidappdev.model.Student

class LoginPageFragment: Fragment() {
    //creating reference to viewModel
    private val viewModel: LoginPageViewModel by viewModels()

    private lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Use viewModel in loginPageFragment
        println(viewModel::class.java)
        button = view.findViewById(R.id.login)

        button.setOnClickListener{
            //Navigate to destination using Fragment Directions
            val action = LoginPageFragmentDirections.actionLoginPageFragmentToDashboardFragment(username = "Zeba", password = "s4604460", student = Student(username = "Zeba", password = "s4604460"))
            findNavController().navigate(action)
        }

    }
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.d.l)
    }*/

}