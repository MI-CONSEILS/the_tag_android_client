package com.mokhtarihadjmohamed.thetag.data.remote.entities

/*
* This is order class and have getTotal function that is test in order test and is return total of
* the order.
* */

class Order(
    val id: String,
    val products: List<Product>,
    val date: String
){
    fun getTotal(): Double {
        var total = 0.0
        products.forEach { product ->  total += (product.price * product.amount)}
        return total
    }
}