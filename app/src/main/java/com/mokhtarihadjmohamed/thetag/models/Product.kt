package com.mokhtarihadjmohamed.thetag.models

/*
* This is Product class
* */

class Product(
    val name: String,
    val description: String,
    val price: Double,
    val imageURl: String,
    val amount: Int = 0,
    val type: String,
    val additions: List<Addition> = listOf()
)