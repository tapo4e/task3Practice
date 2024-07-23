package com.example.mbanking.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mbanking.data.entities.AccountDbEntity
import com.example.mbanking.data.entities.TransactionDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Insert
    suspend fun insertNewAccount(accountDbEntity: AccountDbEntity)

    @Query("SELECT * FROM account")
    fun getAllAccounts(): List<AccountDbEntity>
}