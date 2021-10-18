package com.example.forevera1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forevera1.adapter.ExpensesAdapter
import com.example.forevera1.databinding.FragmentResultBinding
import com.example.forevera1.models.Expense
import com.example.forevera1.services.ExpenseConnection
import kotlinx.android.synthetic.main.fragment_result.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Toast.makeText(activity, getString(R.string.loading_data), Toast.LENGTH_SHORT).show()
        getExpenses()

        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            with(it) {

                btBackResult.setOnClickListener {
                    findNavController()
                        .navigate(
                            R.id.action_resultFragment_to_searchFragment
                        )
                }

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null

    }

    private fun getExpenses() {

        ExpenseConnection().service.getExpenses("Campinas", "2020", "7")
            .enqueue(object : Callback<List<Expense>> {

                override fun onResponse(
                    call: Call<List<Expense>>,
                    response: Response<List<Expense>>
                ) {

                    if (!response.isSuccessful) {
                        Toast.makeText(activity, getString(R.string.failed_search), Toast.LENGTH_SHORT)
                            .show()
                        return
                    }

                    showData(response.body()!!)

                }

                override fun onFailure(call: Call<List<Expense>>, t: Throwable) {
                    Toast.makeText(activity, getString(R.string.failed_search), Toast.LENGTH_SHORT).show()
                }

            })

    }

    private fun showData(expenses: List<Expense>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ExpensesAdapter(expenses)
        }
    }

}