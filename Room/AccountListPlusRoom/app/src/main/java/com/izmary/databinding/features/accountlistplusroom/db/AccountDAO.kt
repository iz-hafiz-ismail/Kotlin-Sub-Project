package com.izmary.databinding.features.accountlistplusroom.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Set Data Access Object
@Dao
interface AccountDAO {

    // Insert new account
    @Insert
    suspend fun insertAccount(account: Account): Long

    // Update an account
    @Update
    suspend fun updateAccount(account: Account): Int

    // Delete an account
    @Delete
    suspend fun deleteAccount(account: Account): Int

    // Run query at runtime
    @Query("DELETE FROM account_data_table")
    suspend fun deleteAll(): Int

    // Get all account data
    @Query("SELECT * FROM account_data_table")
    fun getAllAccounts(): Flow<List<Account>>


}