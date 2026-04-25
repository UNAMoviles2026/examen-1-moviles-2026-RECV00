package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.MockData
import com.moviles.examenmoviles.ui.components.SpaceCard

@Composable
fun HomeScreen(
    onSpaceClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(MockData.coworkingSpaces) { space ->
            SpaceCard(
                space = space,
                onClick = { onSpaceClick(space.id) }
            )
        }
    }
}
