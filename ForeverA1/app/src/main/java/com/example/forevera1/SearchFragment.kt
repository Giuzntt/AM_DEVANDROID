package com.example.forevera1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.forevera1.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            with(it) {

                val municipios = resources.getStringArray(R.array.municipios)
                val arrayAdapterMunicipios = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, municipios)
                binding!!.actvMunicipio.setAdapter(arrayAdapterMunicipios)

                val fileType = resources.getStringArray(R.array.file_type)
                val arrayAdapterFileType = ArrayAdapter(requireContext(), R.layout.dropdown_file_type, fileType)
                binding!!.actvSelectFile.setAdapter(arrayAdapterFileType)

                btBackSearch.setOnClickListener {
                    activity?.onBackPressed()
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null

    }

}