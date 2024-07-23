package com.example.mbanking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mbanking.data.AppDataBase

class MainViewModel(dataBase: AppDataBase) : ViewModel() {
    val accountList = dataBase.getAccountDbEntity().getAllAccounts()
    companion object{
        val factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>, extras: CreationExtras): T {
                val dataBase = (checkNotNull(extras[APPLICATION_KEY]) as App).dataBase
                return MainViewModel(dataBase) as T
            }
        }
    }
}