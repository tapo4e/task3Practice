package com.example.mbanking.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbanking.R
import com.example.mbanking.util.TransactionsData


val colorMap = mapOf(
    "Executed" to 0xFF52AB5B,
    "Declined" to 0xFFF5675E,
    "In progress" to 0xFFF1BF37
)

@Composable
fun TransactionCard(modifier: Modifier = Modifier, transactionsData: TransactionsData) {
    Box(
        modifier
            .fillMaxWidth()
            .size(height = 100.dp, width = 0.dp)
            .background(Color.Transparent)
    )
    {
        Column(modifier.padding(start = 15.dp, top = 10.dp)) {
            Text(
                text = transactionsData.company, color = Color.White,
                fontSize = 17.sp
            )
            Text(
                text = transactionsData.date,
                color = Color(0xFFEBEBF5).copy(alpha = 0.4f),
                fontSize = 13.sp
            )
            Text(
                text = transactionsData.transactionStatus,
                color = Color(colorMap[transactionsData.transactionStatus]!!),
                fontSize = 13.sp
            )
        }
        Row(
            modifier
                .align(Alignment.TopEnd)
                .padding(top = 10.dp, end = 20.dp)
                .wrapContentSize()
        ) {
            Text(
                text = "$${transactionsData.amount}",
                color = Color.White,
                fontSize = 17.sp,
                modifier = modifier.padding(end = 10.dp)
            )
            Spacer(modifier
                .padding(top = 4.dp)
                .drawWithCache {
                    val path = Path()
                    path.moveTo(0f, 0f)
                    path.lineTo(size.width, size.height / 2f)
                    path.lineTo(0f, size.height)
                    onDrawBehind {
                        drawPath(
                            path,
                            color = Color(0xFFEBEBF5).copy(alpha = 0.3f),
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionCardPreview() {
    TransactionCard(transactionsData = TransactionsData.First)
}