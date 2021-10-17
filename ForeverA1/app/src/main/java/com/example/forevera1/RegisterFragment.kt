package com.example.forevera1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.forevera1.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var binding: FragmentRegisterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding?.root
        //BINDING
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            with(it) {
                btRegister.setOnClickListener {
                    val email = tieRegisterEmail.text.toString()
                    val password = tieRegisterPassword.text.toString()

                    if (email.isBlank()) {
                        tilLoginEmail.error = getString(R.string.field_empty_invalid)
                    } else {
                        tilLoginEmail.isErrorEnabled = false
                    }

                    if (password.isBlank()) {
                        tilLoginPassword.error = getString(R.string.field_empty_invalid)
                    } else {
                        tilLoginPassword.isErrorEnabled = false
                    }

                    if (email.isNotBlank() && password.isNotBlank()) {

                        findNavController()
                            .navigate(
                                R.id.action_registerFragment_to_mainFragment
                            )
                    }

                }

            }

        }

    }





    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}