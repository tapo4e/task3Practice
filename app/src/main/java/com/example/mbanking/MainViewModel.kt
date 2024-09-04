package com.example.mbanking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mbanking.data.AppDataBase
import com.example.mbanking.data.entities.AccountDbEntity
import com.example.mbanking.data.entities.TransactionDbEntity
import com.example.mbanking.util.accountValue
import com.example.mbanking.util.transactionIter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val dataBase: AppDataBase) : ViewModel() {
    val accounts: List<AccountDbEntity> = dataBase.getAccountDbEntity().getAllAccounts()

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>, extras: CreationExtras
            ): T {
                val dataBase = (checkNotNull(extras[APPLICATION_KEY]) as App).dataBase
                return MainViewModel(dataBase) as T
            }
        }
    }

    private val _transactions = MutableStateFlow(dataBase.getTransactionDbEntity().getTransaction())
    val transactions = _transactions.asStateFlow()

    init {
        getTransactions(accountValue.value)
        changeAccount()
    }

    private fun getTransactions(transaction: Int) {
        viewModelScope.launch { //this: CoroutineScope
            dataBase.getTransactionDbEntity().getAllAccountTransactions(transaction + 1)
                .flowOn(Dispatchers.IO).collect { transaction: List<TransactionDbEntity> ->
                    _transactions.update { transaction }
                }
        }
    }

    private fun changeAccount() {
        viewModelScope.launch {
            accountValue.collect { newValue ->
                getTransactions(newValue)
            }
        }
        println("work")
    }

    fun insertTransaction(transactionDbEntity:TransactionDbEntity){
        viewModelScope.launch{
        dataBase.getTransactionDbEntity().insertTransaction(transactionDbEntity)
        }
    }
    fun updateTransaction(transactionDbEntity: TransactionDbEntity) {
        println(transactionDbEntity)
        viewModelScope.launch {
            dataBase.getTransactionDbEntity().updateTransaction(transactionDbEntity)
        }
    }
}

