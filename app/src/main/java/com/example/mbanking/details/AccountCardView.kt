package com.example.mbanking.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbanking.R

@Composable
fun AccountCard(modifier: Modifier=Modifier){
    Box(
        modifier
            .fillMaxWidth()
            .size(height = 100.dp, width = 0.dp)
            .drawBehind {
                drawRoundRect(
                    Color(0xFF1C1C1E),
                    cornerRadius = CornerRadius(15.dp.toPx())
                )
            }
    )
    {
        Row(modifier.padding(start = 15.dp, top = 7.dp)) {
            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = "cardImage",
                modifier.size(40.dp)
            )
            Column(modifier.padding(start = 10.dp)) {
                Text(text = "Saving Account", color = Color.White)
                Text(
                    text = "91212192291221",
                    color = Color(0xFFEBEBF5).copy(alpha = 0.4f),
                    fontSize = 13.sp)
                Text(
                    text = "•••• 1234",
                    color = Color(0xFFEBEBF5).copy(alpha = 0.4f),
                    fontSize = 13.sp)
            }

        }
        Spacer(modifier
            .align(Alignment.CenterEnd)
            .padding(end = 20.dp)
            .drawWithCache {
                val path = Path()
                path.moveTo(0f, 0f)
                path.lineTo(size.width, size.height / 2f)
                path.lineTo(0f, size.height)
                onDrawBehind {
                    drawPath(
                        path,
                        color = Color(0xFFEBEBF5).copy(alpha = 0.6f),
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

@Preview(showBackground = true)
@Composable
fun AccountCardPreview() {
        AccountCard()
}