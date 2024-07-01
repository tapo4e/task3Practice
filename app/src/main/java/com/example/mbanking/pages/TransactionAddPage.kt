package com.example.mbanking.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbanking.R
import com.example.mbanking.data.TransactionsData
import com.example.mbanking.details.MyDatePickerDialog
import com.example.mbanking.util.checkAmount
import com.example.mbanking.util.checkCompany
import com.example.mbanking.util.checkDate
import com.example.mbanking.util.checkNumber
import com.example.mbanking.util.checkStatus
import com.example.mbanking.util.resultCheck

@Composable
fun TransactionAddPage(modifier: Modifier = Modifier, onClick: () -> Unit) {
    var validError by remember {
        mutableStateOf(false)
    }
    var date by remember {
        mutableStateOf("")
    }
    var sheetState by remember { mutableStateOf(false) }
    if (sheetState) {
        MyDatePickerDialog(onDateSelected = { date = it }, onDismiss = { sheetState = false })
    }
    println(date)
    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Transaction",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Transaction was applied in",
                color = Color.White,
                fontSize = 17.sp,
                modifier = modifier.padding(top = 30.dp),
                fontWeight = FontWeight.Light
            )
            var company by remember { mutableStateOf("") }
            OutlinedTextField(
                value = company, onValueChange = { company = it },
                modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(Color.White),
                isError = checkCompany(company, validError)
            )
            Text(
                text = "Transaction number",
                color = Color.White,
                fontSize = 17.sp,
                modifier = modifier.padding(top = 15.dp),
                fontWeight = FontWeight.Light
            )
            var number by remember { mutableStateOf("") }
            OutlinedTextField(
                value = number, onValueChange = { number = it },
                modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(Color.White),
                isError = checkNumber(number, validError)
            )
            Text(
                text = "Date",
                color = Color.White,
                fontSize = 17.sp,
                modifier = modifier.padding(top = 15.dp),
                fontWeight = FontWeight.Light
            )
            OutlinedTextField(
                value = date, onValueChange = { date = it },
                readOnly = true,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(Color.White),
                isError = checkDate(date, validError),
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier
                            .clickable { sheetState = true }
                            .size(20.dp))
                }
            )
            Text(
                text = "Transaction status",
                color = Color.White,
                fontSize = 17.sp,
                modifier = modifier.padding(top = 15.dp),
                fontWeight = FontWeight.Light
            )
            var status by remember { mutableStateOf("") }
            OutlinedTextField(
                value = status, onValueChange = { status = it },
                modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(Color.White),
                isError = checkStatus(status, validError)
            )
            Text(
                text = "Amount",
                color = Color.White,
                fontSize = 17.sp,
                modifier = modifier.padding(top = 15.dp),
                fontWeight = FontWeight.Light
            )
            var amount by remember { mutableStateOf("") }
            OutlinedTextField(
                value = amount, onValueChange = { amount = it },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(Color.White),
                isError = checkAmount(amount, validError)
            )
            val transaction =
                TransactionsData(company, date, status, amount, number)
            Button(
                onClick = {
                    if (resultCheck(company, amount, date, status, number)) {
                        listOfAccounts[accountValue].listOfTransctions =
                            listOfAccounts[accountValue].listOfTransctions + transaction
                        onClick()
                        validError = false
                    } else {
                        validError = true
                    }
                },
                modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF409CFF)),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(text = "Okay", fontSize = 17.sp, fontWeight = FontWeight.Bold)
            }
        }

    }
}
@Preview
@Composable
fun TransactionAddPagePreview() {
    TransactionAddPage {}
}



