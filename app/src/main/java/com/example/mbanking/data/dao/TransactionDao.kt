package com.example.mbanking.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.mbanking.data.entities.TransactionDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transactionDbEntity: TransactionDbEntity)

    @Query("SELECT * FROM transactions WHERE account_id = :accountId")
    fun getAllAccountTransactions(accountId:Int): Flow<List<TransactionDbEntity>>
    @Query("SELECT * FROM transactions WHERE account_id = 1")
    fun getTransaction(): List<TransactionDbEntity>

    @Update
    suspend fun updateTransaction(transactionDbEntity: TransactionDbEntity)
}