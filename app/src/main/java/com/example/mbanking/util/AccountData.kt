package com.example.mbanking.util

sealed class AccountData(
    var accountName: String,
    var bankAccountNumber: String,
    var cardNumber: String,
    var listOfTransctions: List<TransactionsData>
) {
    data object First : AccountData(
        accountName = "Haribor",
        bankAccountNumber = "91212192291221",
        cardNumber = "1234",
        listOfTransctions = listOf(
            TransactionsData("Alpha-bank", "30.04.2024", "Executed", "10.3"),
            TransactionsData("BNB-bank", "01.04.2024", "Declined", "100.3"),
            TransactionsData("T-bank","29.04.2024","Executed","200.3"),
            TransactionsData("Alpha-bank","30.04.2024","In progress","10.3")
        )
    )
    data object Second : AccountData(
        accountName = "Byblik",
        bankAccountNumber = "91212193391221",
        cardNumber = "7766",
        listOfTransctions = listOf(
            TransactionsData("Alpha-bank", "30.04.2024", "Executed", "20.3"),
            TransactionsData("BNB-bank", "01.04.2024", "Executed", "100.3"),
            TransactionsData("T-bank","29.04.2024","Executed","200.3"),
            TransactionsData("Alpha-bank","30.04.2024","Executed","10.3")
        )
    )
    data object Third : AccountData(
        accountName = "Jackson",
        bankAccountNumber = "91212192295555",
        cardNumber = "6005",
        listOfTransctions = listOf(
            TransactionsData("Alpha-bank", "30.04.2024", "Executed", "100.3"),
            TransactionsData("BNB-bank", "01.04.2024", "Declined", "100.3"),
            TransactionsData("T-bank","29.04.2024","Executed","500.3"),
            TransactionsData("Alpha-bank","30.04.2024","In progress","10.3")
        )
    )

}