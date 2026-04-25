package com.moviles.examenmoviles.model

data class CoworkingSpace(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val imageRes: Int,
    val isAvailable: Boolean
)
