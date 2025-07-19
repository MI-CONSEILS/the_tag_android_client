package com.mokhtarihadjmohamed.thetag.model

/*
* This is Product class
* */

class Product(
    val name: String,
    val description: String,
    val price: Double,
    val imageURl: String,
    val amount: Int = 0
)