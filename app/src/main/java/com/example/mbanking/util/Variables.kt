package com.example.mbanking.util

import com.example.mbanking.data.AccountData
import kotlinx.coroutines.flow.MutableStateFlow

const val defaultStartDate = "01.01.1970"
const val defaultEndDate = "30.01.3000"
var transactionIter = 0
var accountValue = MutableStateFlow(0)
val listOfStatus = listOf("Executed","In progress","Declined")
