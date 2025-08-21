package com.mokhtarihadjmohamed.thetag

import com.mokhtarihadjmohamed.thetag.data.remote.entities.Order
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Product
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertNotEquals

class OrderUnitTest {
    val order = Order(
        id = "458",
        products = listOf(
            Product(
                name = "Burger  - SM Lucena",
                description = "Grillé à la flamme pour un goût inimitable",
                price = 18.0,
                imageURl = "",
                amount = 1
            ),
            Product(
                name = "Burger  - SM Lucena",
                description = "Grillé à la flamme pour un goût inimitable",
                price = 18.0,
                imageURl = "",
                amount = 2
            )
        ),
        date = "8 Avril 2025"
    )

    @Test
    fun total_is_correct_false() {
        assertNotEquals(44.0, order.getTotal(), 0.001)
    }

    @Test
    fun total_is_correct_true() {
        assertEquals(54.0, order.getTotal(), 0.001)
    }
}