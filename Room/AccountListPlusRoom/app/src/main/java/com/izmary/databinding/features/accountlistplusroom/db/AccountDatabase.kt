package com.izmary.databinding.features.accountlistplusroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Account::class], version = 1)
abstract class AccountDatabase : RoomDatabase() {
    abstract val uAccountDAO: AccountDAO

    //to avoid from data base been accessed by multiple class at one time. Lock and key method is use
    companion object {
        @Volatile
        private var INSTANCE: AccountDatabase? = null
        fun getInstance(context: Context): AccountDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AccountDatabase::class.java,
                        "account_data_database"
                    ).build()
                }
                return instance
            }
        }

    }


}