package com.example.mbanking.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mbanking.pages.accountNumber
import com.example.mbanking.pages.listOfAccounts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit,modifier: Modifier=Modifier,scope:CoroutineScope,modalBottomSheetState:SheetState) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        containerColor = Color.Black,
        shape = CutCornerShape(0.dp),
        dragHandle = {
            BottomSheetDefaults.DragHandle(color = Color.White)
        } ,
    ) {
        LazyColumn(
            modifier
                .fillMaxSize()
                .background(Color.Black)) {
            items(listOfAccounts.size) { value->
                AccountCard (accountData  = listOfAccounts[value],onClick = {
                    scope.launch { modalBottomSheetState.hide() }.invokeOnCompletion { onDismiss()
                    accountNumber=value}
                })
            }
        }
    }
}