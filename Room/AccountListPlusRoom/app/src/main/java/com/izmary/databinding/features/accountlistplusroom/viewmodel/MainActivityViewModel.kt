package com.izmary.databinding.features.accountlistplusroom.viewmodel

import androidx.lifecycle.*
import com.izmary.databinding.features.accountlistplusroom.Event
import com.izmary.databinding.features.accountlistplusroom.db.Account
import com.izmary.databinding.features.accountlistplusroom.db.AccountRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: AccountRepository) : ViewModel() {

    // Variable for knowing whether an account is select or not (true -> selected, false -> not selected)
    private var isUpdateOrDelete = false
    // Assign account if selected
    private lateinit var accountToUpdateOrDelete: Account

    // User input and also to display account name if account selected
    val inputName = MutableLiveData<String>()

    // Button text
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    // Status Message (Optional)
    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    // Constructor
    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    // I prefer to use fragment for below function to split this. But I need to find job ASAP haha so i just modified the tutorial
    // The currency data type also need to be fix. I use big decimal at first but sqlite does not have big decimal so I convert it to Int. Later on i will change into proper data type
    // Currency cant use float or double because of accuracy issue especially for sensitive stuff like currency

    // Save or Update.
    fun saveOrUpdate() {
        if (inputName.value == null) {
            statusMessage.value = Event("Please enter subscriber's name")
        } else {
            if (isUpdateOrDelete) {
                accountToUpdateOrDelete.name = inputName.value!!
                update(accountToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val amount = 8420
                val number = java.util.UUID.randomUUID().toString()
                val status = "Balanced"
                insert(Account(0, name, amount, number,status))
                inputName.value = ""
            }

        }
    }

    // delete an account or all account
    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(accountToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    // Insert new account
    fun insert(account: Account) = viewModelScope.launch {
        val newRowId = repository.insert(account)
        if (newRowId > -1) {
            statusMessage.value = Event("Subscriber Inserted Successfully $newRowId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    // Update an account
    fun update(account: Account) = viewModelScope.launch {
        val noOfRows = repository.update(account)
        if (noOfRows > 0) {
            inputName.value = ""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$noOfRows Row Updated Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }

    }

    // Delete an account
    fun delete(account: Account) = viewModelScope.launch {
        val noOfRowsDeleted = repository.delete(account)
        if (noOfRowsDeleted > 0) {
            inputName.value = ""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$noOfRowsDeleted Row Deleted Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    // Delete all account
    fun clearAll() = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteAll()
        if (noOfRowsDeleted > 0) {
            statusMessage.value = Event("$noOfRowsDeleted Subscribers Deleted Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    // Setup when account was selected
    fun initUpdateAndDelete(account: Account) {
        inputName.value = account.name
        isUpdateOrDelete = true
        accountToUpdateOrDelete = account
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    // well as it name suggest, it for get all account
    fun getSaveUAccounts() = liveData {
        repository.Accounts.collect {
            emit(it)
        }
    }
}