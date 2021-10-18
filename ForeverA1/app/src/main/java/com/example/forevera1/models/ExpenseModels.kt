package com.example.forevera1.models

data class Expense(
    val orgao: String,
    val mes: String,
    val evento: String,
    val nr_empenho: String,
    val id_fornecedor: String,
    val nm_fornecedor: String,
    val dt_emissao_despesa: String,
    val vl_despesa: String
)