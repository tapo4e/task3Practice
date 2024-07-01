package com.example.mbanking.details


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.mbanking.pages.newEndDate
import com.example.mbanking.pages.newStartDate
import com.example.mbanking.util.checkDate
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateBottomSheet(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var validError by remember { mutableStateOf(false) }
    var startDateSheet by remember { mutableStateOf("") }
    var endDateSheet by remember { mutableStateOf("") }
    var startSheetState by remember { mutableStateOf(false) }
    var endSheetState by remember { mutableStateOf(false) }
    if (startSheetState) {
        MyDatePickerDialog(
            onDateSelected = { startDateSheet = it },
            onDismiss = { startSheetState = false })
    } else if (endSheetState) {
        MyDatePickerDialog(
            onDateSelected = { endDateSheet = it },
            onDismiss = { endSheetState = false })
    }
    val scope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
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
                    text = "Filter by date",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Start date",
                    color = Color.White,
                    fontSize = 17.sp,
                    modifier = modifier.padding(top = 30.dp),
                    fontWeight = FontWeight.Light
                )
                OutlinedTextField(
                    value = startDateSheet, onValueChange = { startDateSheet = it },
                    modifier
                        .fillMaxWidth()
                        .padding(top = 7.dp),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(Color.White),
                    isError = checkDate(startDateSheet, validError),
                    readOnly = true,
                    trailingIcon = {
                        Icon(painter = painterResource(id = R.drawable.calendar),
                            contentDescription = null,
                            modifier
                                .clickable { startSheetState = true }
                                .size(20.dp))
                    }
                )
                Text(
                    text = "End date",
                    color = Color.White,
                    fontSize = 17.sp,
                    modifier = modifier.padding(top = 15.dp),
                    fontWeight = FontWeight.Light
                )
                OutlinedTextField(
                    value = endDateSheet,
                    onValueChange = { endDateSheet = it },
                    modifier
                        .fillMaxWidth()
                        .padding(top = 7.dp),
                    shape = RoundedCornerShape(10.dp),
                    textStyle = TextStyle(Color.White),
                    isError = checkDate(endDateSheet, validError),
                    readOnly = true,
                    trailingIcon = {
                        Icon(painter = painterResource(id = R.drawable.calendar),
                            contentDescription = null,
                            modifier
                                .clickable { endSheetState = true }
                                .size(20.dp))
                    }
                )
                Button(
                    onClick = {
                        validError = if (startDateSheet != "" && endDateSheet != "") {
                            scope.launch { modalBottomSheetState.hide() }.invokeOnCompletion {
                                onDismiss()
                                newStartDate = startDateSheet
                                newEndDate = endDateSheet
                            }
                            false
                        } else {
                            true
                        }
                    },
                    modifier
                        .padding(top = 40.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF409CFF)),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(text = "Submit", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview
@Composable
fun DateBottomSheetPReview() {
    DateBottomSheet(onDismiss = { /*TODO*/ })
}


