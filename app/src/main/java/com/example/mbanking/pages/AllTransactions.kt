package com.example.mbanking.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbanking.details.TransactionCard

@Composable
fun AllTransactions(modifier: Modifier = Modifier,
                    onClickBackButton:()->Unit) {
    Column(
        modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(modifier.fillMaxWidth()) {
            Spacer(modifier
                .align(Alignment.CenterVertically)
                .clickable { onClickBackButton() }
                .drawWithCache {
                    val path = Path()
                    path.moveTo(size.width, 0f)
                    path.lineTo(0f, size.height / 2f)
                    path.lineTo(size.width, size.height)
                    onDrawBehind {
                        drawPath(
                            path,
                            color = Color.White,
                            style = Stroke(
                                width = 5f,
                                pathEffect = PathEffect.cornerPathEffect(2.dp.toPx()),
                                cap = StrokeCap.Round
                            )
                        )
                    }
                }
                .width(8.dp)
                .height(15.dp)
            )
            Text(
                text = "All transactions",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier=modifier.padding(start=90.dp)
            )
        }
        Spacer(modifier.size(20.dp))
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .drawBehind {
                    drawRoundRect(
                        Color(0xFF1C1C1E),
                        cornerRadius = CornerRadius(15.dp.toPx())
                    )
                }) {
            items(listOfAccounts[accountValue].listOfTransctions.size) { value ->
                val it = listOfAccounts[accountValue].listOfTransctions.size - value - 1
                TransactionCard(transactionsData = listOfAccounts[accountValue].listOfTransctions[it])
                {

                }
                Divider(
                    modifier.padding(start = 15.dp, end = 15.dp),
                    color = Color(0xFF545458).copy(0.65f),
                    thickness = 0.5.dp
                )
            }
        }
    }
}

@Preview
@Composable
fun AllTransactionsPreview() {
    AllTransactions(){

    }
}