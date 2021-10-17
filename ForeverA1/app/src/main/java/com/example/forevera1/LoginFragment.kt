package com.example.forevera1
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.forevera1.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            with(it) {
                btLogin.setOnClickListener {
                    val email = tieLoginEmail.text.toString()
                    val password = tieLoginPassword.text.toString()

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
                                R.id.action_loginFragment_to_mainFragment
                            )
                    }

                }
                tvCadastro.setOnClickListener {
                    findNavController()
                        .navigate(
                            R.id.action_loginFragment_to_registerFragment2
                        )
                }


            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}