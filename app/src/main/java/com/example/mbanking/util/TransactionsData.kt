package com.example.mbanking.util

sealed class TransactionsData(
    val company: String,
    val date : String,
    val transactionStatus: String,
    val amount:String
) {

    data object First : TransactionsData(
        company = "Alpha-bank",
        date = "30.04.2024",
        transactionStatus = "Executed",
        amount = "100.3"
    )
    data object Second : TransactionsData(
        company = "T-bank",
        date = "01.05.2024",
        transactionStatus = "Declined",
        amount = "10.3"
    )
    data object Third : TransactionsData(
        company = "BNB-bank",
        date = "4.04.2024",
        transactionStatus = "In progress",
        amount = "200.3"
    )
    data object Four : TransactionsData(
        company = "Alpha-bank",
        date = "28.04.2024",
        transactionStatus = "Executed",
        amount = "100.3"
    )
}