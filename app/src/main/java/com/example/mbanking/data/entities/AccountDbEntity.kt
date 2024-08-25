package com.example.mbanking.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class AccountDbEntity(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "bank_number") val bankAccountNumber : Long,
    @ColumnInfo(name = "account_name") val accountName : String,
    @ColumnInfo(name = "last_card_digits") val cardNumber : Int
)