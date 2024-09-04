package com.example.mbanking

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mbanking.pages.AllTransactions
import com.example.mbanking.pages.MainWindow
import com.example.mbanking.pages.TransactionAddPage
import com.example.mbanking.pages.TransactionChangePage
import com.example.mbanking.ui.theme.MBankingTheme
import com.example.mbanking.util.transactionIter

class MainActivity : ComponentActivity() {
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MBankingTheme {
                val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
                NavHost(
                    navController = navController,
                    startDestination = "main_screen"
                )
                {
                    composable("main_screen") {
                        MainWindow(
                            onClickAddButton = { navController.navigate("transaction_add") },
                            onClickTransactionButton = { navController.navigate("transaction_change")
                                                       transactionIter = it},
                            onClickViewAllButton = { navController.navigate("all_transactions") },
                            accountData = mainViewModel.accounts,
                            transactionData = mainViewModel.transactions,

                        )

                    }
                    composable("transaction_add") {
                        TransactionAddPage(onClick = {
                            navController.navigate("main_screen") {
                                popUpTo("main_screen") {
                                    inclusive = true
                                }
                            }
                        },
                            insertTransaction = mainViewModel::insertTransaction)
                    }
                    composable("transaction_change") {
                        TransactionChangePage(
                            onClick = {
                            navController.navigate("main_screen") {
                                popUpTo("main_screen") {
                                    inclusive = true
                                }
                            }
                        }, transactionsData = mainViewModel.transactions.value[transactionIter],
                            onEvent = mainViewModel::updateTransaction)

                    }
                    composable("all_transactions") {
                        AllTransactions(onClickTransactionButton = {
                            transactionIter = it
                            navController.navigate("change_transactions_all_page") {
                            }
                        }, onClickBackButton = {
                            navController.navigate("main_screen") {
                                popUpTo("main_screen") {
                                    inclusive = true
                                }
                            }
                        },
                            transactionsData = mainViewModel.transactions.value

                        )

                    }
                    composable("change_transactions_all_page") {
                        TransactionChangePage(onClick = {
                            navController.navigate("all_transactions") {
                                popUpTo("all_transactions") {
                                    inclusive = true
                                }
                            }
                        },
                            transactionsData = mainViewModel.transactions.value[transactionIter],
                            onEvent = mainViewModel::updateTransaction)
                    }
                }
            }
        }
    }
}