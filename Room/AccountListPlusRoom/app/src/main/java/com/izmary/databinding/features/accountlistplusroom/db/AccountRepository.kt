package com.izmary.databinding.features.accountlistplusroom.db

// Repository for account. It no recommend activity directly interact with dao. Repository act as middleman between data and activity
class AccountRepository(private val dao: AccountDAO) {

    val Accounts = dao.getAllAccounts()

    suspend fun insert(account: Account): Long {
        return dao.insertAccount(account)
    }

    suspend fun update(account: Account): Int {
        return dao.updateAccount(account)
    }

    suspend fun delete(account: Account): Int {
        return dao.deleteAccount(account)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAll()
    }


}