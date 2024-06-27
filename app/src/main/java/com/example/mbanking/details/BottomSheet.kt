package com.example.mbanking.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbanking.pages.accountValue
import com.example.mbanking.pages.listOfAccounts
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val modalBottomSheetState= rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        modifier = modifier.fillMaxHeight(0.6f),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        containerColor = Color.Black,
        shape = CutCornerShape(0.dp),
        dragHandle = {
            BottomSheetDefaults.DragHandle(color = Color.White)
        }
    ) {
        Column(
            modifier
                .background(Color.Black)
                .padding(start = 10.dp, end = 10.dp)
        ) {

            Text(
                text = "Select the account",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(
                modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)

            ) {
                items(listOfAccounts.size) { value ->
                    AccountCard(accountData = listOfAccounts[value], onClick = {
                        scope.launch { modalBottomSheetState.hide() }.invokeOnCompletion {
                            onDismiss()
                            accountValue = value
                        }
                    })
                    Spacer(modifier.size(10.dp))
                }
            }
        }
    }
}


