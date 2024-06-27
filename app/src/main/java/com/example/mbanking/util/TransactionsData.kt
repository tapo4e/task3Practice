package com.example.mbanking.util

class TransactionsData(
    private var company: String,
    private var date: String,
    private var transactionStatus: String,
    private var amount: String,
    private var transactionNumber : String
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
    fun setCompany(company: String){
        this.company=company
    }
    fun setDate(date: String){
        this.date=date
    }
    fun setTransactionStatus(transactionStatus: String){
        this.transactionStatus=transactionStatus
    }
    fun setAmount(amount: String){
        this.amount =amount
    }
    fun setTransactionNumber(transactionNumber: String){
        this.transactionNumber=transactionNumber
    }
}