package com.example.mbanking.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mbanking.data.dao.AccountDao
import com.example.mbanking.data.dao.TransactionDao
import com.example.mbanking.data.entities.AccountDbEntity
import com.example.mbanking.data.entities.TransactionDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class,
        TransactionDbEntity::class
    ],

)
abstract class AppDataBase:RoomDatabase() {
    companion object{
        fun createDataBase(context: Context):AppDataBase{
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "main3.db"
            ).createFromAsset("mbanking.db")
                .allowMainThreadQueries()
                .build()
        }
    }
    abstract fun getTransactionDbEntity() : TransactionDao
    abstract fun getAccountDbEntity() : AccountDao
}