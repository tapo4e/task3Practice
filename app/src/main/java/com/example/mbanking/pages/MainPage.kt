package com.example.mbanking.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbanking.buttons.AddButton
import com.example.mbanking.details.AccountCard
import com.example.mbanking.details.BottomSheet
import com.example.mbanking.details.TransactionCard
import com.example.mbanking.ui.theme.MBankingTheme
import com.example.mbanking.data.AccountData
import com.example.mbanking.util.accountValue
import com.example.mbanking.util.listOfAccounts


@Composable
fun MainWindow(
    modifier: Modifier = Modifier,
    onClickAddButton: () -> Unit,
    onClickTransactionButton: () -> Unit,
    onClickViewAllButton: () -> Unit
) {
    var accountNumber by remember { mutableIntStateOf(0) }
    accountNumber = accountValue
    var showSheet by remember { mutableStateOf(false) }
    if (showSheet) {
        BottomSheet(onDismiss = {
            showSheet = false
        })
    }
    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Text(
                text = "Account",
                fontSize = 28.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier.size(20.dp))
            AccountCard(accountData = listOfAccounts[accountNumber], onClick = {
                showSheet = true
            }
            )
            Spacer(modifier.size(20.dp))
            Box(
                modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Recent Transactions",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "VIEW ALL",
                    modifier
                        .align(Alignment.CenterEnd)
                        .clickable { onClickViewAllButton() },
                    fontSize = 14.sp,
                    color = Color(0xFF409CFF)
                )
            }
            Spacer(modifier.size(20.dp))
            LazyColumn(
                modifier = modifier
                    .wrapContentSize()
                    .drawBehind {
                        drawRoundRect(
                            Color(0xFF1C1C1E),
                            cornerRadius = CornerRadius(15.dp.toPx())
                        )
                    }) {
                items(4) { value ->
                    val it = listOfAccounts[accountNumber].listOfTransctions.size - value - 1
                    TransactionCard(transactionsData = listOfAccounts[accountNumber].listOfTransctions[it])
                    {

                        onClickTransactionButton()
                    }
                    Divider(
                        modifier.padding(start = 15.dp, end = 15.dp),
                        color = Color(0xFF545458).copy(0.65f),
                        thickness = 0.5.dp
                    )
                }
            }
        }
        Box(
            modifier
                .align(Alignment.BottomEnd)
                .wrapContentSize()
                .padding(bottom = 50.dp, end = 20.dp)
        ) {
            AddButton { onClickAddButton() }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MBankingTheme {
        MainWindow(onClickAddButton = {}, onClickViewAllButton = {},
            onClickTransactionButton = {})
    }
}