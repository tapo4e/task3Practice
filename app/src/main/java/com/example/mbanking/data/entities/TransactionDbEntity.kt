package com.example.mbanking.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "transactions",
    indices = [Index("id")],
    foreignKeys =[
        ForeignKey(
            entity = AccountDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["account_id"]
        )
    ]
    )
data class TransactionDbEntity(
    @PrimaryKey(autoGenerate = true) val id :Long = 0,
    @ColumnInfo(name = "account_id") val accountId : Int ,
    val company: String,
    val date: String,
    @ColumnInfo(name = "transaction_status") val transactionStatus: String,
    val amount: String,
    @ColumnInfo(name = "transaction_number") val transactionNumber : String
)
