package com.izmary.databinding.rv.accountlist.model

import java.math.BigDecimal

//model for account
data class AccountData(
    val name:String,
    var amount: BigDecimal? = BigDecimal.ZERO,
    var number: String,
    val status: String)