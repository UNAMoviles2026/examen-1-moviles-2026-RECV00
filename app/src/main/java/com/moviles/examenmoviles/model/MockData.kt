package com.moviles.examenmoviles.model

import com.moviles.examenmoviles.R

object MockData {
    val coworkingSpaces = listOf(
        CoworkingSpace(
            id = 1,
            name = "Creative Hub",
            description = "A vibrant space for designers and artists with plenty of natural light and modern amenities.",
            location = "Downtown, Arts District",
            capacity = 20,
            pricePerHour = 15.0,
            imageRes = R.drawable.coworking_image,
            isAvailable = true
        ),
        CoworkingSpace(
            id = 2,
            name = "Tech Connect",
            description = "High-speed internet and ergonomic furniture, perfect for developers and tech startups.",
            location = "Silicon Valley Plaza",
            capacity = 50,
            pricePerHour = 25.0,
            imageRes = R.drawable.coworking_image,
            isAvailable = true
        ),
        CoworkingSpace(
            id = 3,
            name = "Quiet Corner",
            description = "A peaceful environment designed for deep focus and individual work. No phone calls allowed in this area.",
            location = "Quiet Street, Suburbs",
            capacity = 10,
            pricePerHour = 10.0,
            imageRes = R.drawable.coworking_image,
            isAvailable = false
        ),
        CoworkingSpace(
            id = 4,
            name = "Collaborative Loft",
            description = "Open space with several meeting rooms and whiteboards. Ideal for team brainstorming sessions.",
            location = "Industrial Zone, Block B",
            capacity = 30,
            pricePerHour = 20.0,
            imageRes = R.drawable.coworking_image,
            isAvailable = true
        )
    )
}
