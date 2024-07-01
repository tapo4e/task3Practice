package com.example.mbanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mbanking.pages.AllTransactions
import com.example.mbanking.pages.MainWindow
import com.example.mbanking.pages.TransactionAddPage
import com.example.mbanking.pages.TransactionChangePage
import com.example.mbanking.ui.theme.MBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MBankingTheme {
                NavHost(
                    navController = navController,
                    startDestination = "main_screen"
                )
                {
                    composable("main_screen") {
                        MainWindow(
                            onClickAddButton = { navController.navigate("transaction_add") },
                            onClickTransactionButton = { navController.navigate("transaction_change") },
                            onClickViewAllButton = { navController.navigate("all_transactions")})

                    }
                    composable("transaction_add") {
                        TransactionAddPage {
                            navController.navigate("main_screen") {
                                popUpTo("main_screen") {
                                    inclusive = true
                                }
                            }
                        }
                    }
                    composable("transaction_change") {
                        TransactionChangePage(onClick = {
                            navController.navigate("main_screen") {
                                popUpTo("main_screen") {
                                    inclusive = true
                                }
                            }
                        })

                    }
                    composable("all_transactions") {
                        AllTransactions(onClickTransactionButton = {
                            navController.navigate("change_transactions_all_page") {
                            }
                        }, onClickBackButton = {
                            navController.navigate("main_screen") {
                                popUpTo("main_screen") {
                                    inclusive = true
                                }
                            }
                        })

                    }
                    composable("change_transactions_all_page") {
                        TransactionChangePage(onClick = {
                            navController.navigate("all_transactions") {
                                popUpTo("all_transactions") {
                                    inclusive = true
                                }
                            }
                        })
                    }
                }
            }
        }
    }
}