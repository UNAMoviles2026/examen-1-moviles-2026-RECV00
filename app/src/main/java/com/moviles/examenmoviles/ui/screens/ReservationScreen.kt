package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.MockData
import com.moviles.examenmoviles.ui.components.ButtonPrimary

@Composable
fun ReservationScreen(
    spaceId: Int,
    onConfirmClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val space = MockData.coworkingSpaces.find { it.id == spaceId } ?: return
    
    var selectedDate by remember { mutableStateOf("2026-05-10") }
    var selectedTime by remember { mutableStateOf("10:00 AM") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Reserve ${space.name}",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Select date and time for your reservation.",
            style = MaterialTheme.typography.bodyMedium
        )

        OutlinedTextField(
            value = selectedDate,
            onValueChange = { selectedDate = it },
            label = { Text("Date (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = selectedTime,
            onValueChange = { selectedTime = it },
            label = { Text("Start Time") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonPrimary(
            text = "Confirm Reservation",
            onClick = onConfirmClick
        )
    }
}
