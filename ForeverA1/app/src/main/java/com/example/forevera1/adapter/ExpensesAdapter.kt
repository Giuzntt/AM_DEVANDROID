package com.example.forevera1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forevera1.R
import com.example.forevera1.models.Expense

class ExpensesAdapter(private val expenses: List<Expense>) : RecyclerView.Adapter<ExpensesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = expenses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenses[position]
        holder.orgao.text = expense.orgao
        holder.mes.text = expense.mes
        holder.evento.text = expense.evento
        holder.nr_empenho.text = expense.nr_empenho
        holder.id_fornecedor.text = expense.id_fornecedor
        holder.nm_fornecedor.text = expense.nm_fornecedor
        holder.dt_emissao_despesa.text = expense.dt_emissao_despesa
        holder.vl_despesa.text = expense.vl_despesa
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orgao: TextView = itemView.findViewById(R.id.orgao)
        val mes: TextView = itemView.findViewById(R.id.mes)
        val evento: TextView = itemView.findViewById(R.id.evento)
        val nr_empenho: TextView = itemView.findViewById(R.id.nr_empenho)
        val id_fornecedor: TextView = itemView.findViewById(R.id.id_fornecedor)
        val nm_fornecedor: TextView = itemView.findViewById(R.id.nm_fornecedor)
        val dt_emissao_despesa: TextView = itemView.findViewById(R.id.dt_emissao_despesa)
        val vl_despesa: TextView = itemView.findViewById(R.id.vl_despesa)
    }

}