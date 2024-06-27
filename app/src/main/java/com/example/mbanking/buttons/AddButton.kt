package com.example.mbanking.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddButton(
    modifier: Modifier = Modifier,
    onClick:()->Unit
) {
    Box(
        modifier
            .clickable { onClick() }
            .size(50.dp)
            .graphicsLayer {
                clip = true
                shape = CircleShape
            }
            .background(Color(0xFF409CFF)),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier
                .drawWithCache {
                    val path = Path()
                    path.moveTo(size.width / 2f, 0f)
                    path.lineTo(size.width / 2f, size.height)
                    onDrawBehind {
                        drawPath(
                            path,
                            color = Color.White,
                            style = Stroke(
                                width = 7f,
                                pathEffect = PathEffect.cornerPathEffect(2.dp.toPx()),
                                cap = StrokeCap.Round
                            )
                        )
                    }
                }
                .drawWithCache {
                    val path = Path()
                    path.moveTo(0f, size.height / 2f)
                    path.lineTo(size.width, size.height / 2f)
                    onDrawBehind {
                        drawPath(
                            path,
                            color = Color.White,
                            style = Stroke(
                                width = 7f,
                                pathEffect = PathEffect.cornerPathEffect(2.dp.toPx()),
                                cap = StrokeCap.Round
                            )
                        )
                    }
                }
                .size(15.dp)
        )

    }
}


@Preview
@Composable
fun PreviewLoader() {
    AddButton{}
}