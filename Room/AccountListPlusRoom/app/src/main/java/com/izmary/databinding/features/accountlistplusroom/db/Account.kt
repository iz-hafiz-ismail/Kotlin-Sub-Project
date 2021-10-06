package com.izmary.databinding.features.accountlistplusroom.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Set Database
@Entity(tableName = "account_data_table")
data class Account(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "account_id")
    var id: Int,

    @ColumnInfo(name = "account_name")
    var name: String,

    @ColumnInfo(name = "account_amount")
    var amount: Int,

    @ColumnInfo(name = "account_number")
    var number: String,

    @ColumnInfo(name = "account_status")
    var status: String
)
