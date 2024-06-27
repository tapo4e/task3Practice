package com.example.mbanking.util

class TransactionsData(
    private val company: String,
    private val date: String,
    private val transactionStatus: String,
    private val amount: String
) {

    fun getCompany():String{
        return company
    }
    fun getDate():String{
        return date
    }
    fun getTransactionStatus():String{
        return transactionStatus
    }
    fun getAmount():String{
        return amount
    }
}