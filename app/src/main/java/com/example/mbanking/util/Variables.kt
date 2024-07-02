package com.example.mbanking.util

import com.example.mbanking.data.AccountData

const val defaultStartDate = "01.01.1970"
const val defaultEndDate = "30.01.3000"
val listOfAccounts = mutableListOf(AccountData.First, AccountData.Second, AccountData.Third)
var transactionIter = 0
var accountValue: Int = 0