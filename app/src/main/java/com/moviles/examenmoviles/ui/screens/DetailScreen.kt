package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.MockData
import com.moviles.examenmoviles.ui.components.ButtonPrimary
import com.moviles.examenmoviles.ui.components.InfoRow

@Composable
fun DetailScreen(
    spaceId: Int,
    onReserveClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val space = MockData.coworkingSpaces.find { it.id == spaceId } ?: return

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Local Image
        Image(
            painter = painterResource(id = space.imageRes),
            contentDescription = space.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = space.name,
                style = MaterialTheme.typography.headlineLarge
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Description",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = space.description,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Details",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            
            InfoRow(label = "Location", value = space.location, icon = Icons.Default.LocationOn)
            InfoRow(label = "Capacity", value = "${space.capacity} people", icon = Icons.Default.Group)
            InfoRow(label = "Price", value = "$${space.pricePerHour} / hour", icon = Icons.Default.Payments)
            InfoRow(
                label = "Status", 
                value = if (space.isAvailable) "Available Now" else "Not Available",
                icon = null
            )

            Spacer(modifier = Modifier.height(32.dp))

            ButtonPrimary(
                text = if (space.isAvailable) "Reserve Now" else "Not Available",
                onClick = { onReserveClick(space.id) },
                enabled = space.isAvailable
            )
        }
    }
}
