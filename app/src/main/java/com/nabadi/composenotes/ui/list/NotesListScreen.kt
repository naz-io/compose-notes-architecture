package com.nabadi.composenotes.ui.list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotesListScreen(
    uiState: NotesListUiState,
    modifier: Modifier = Modifier,
) {
    // Placeholder only. No UI polish.
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Notes",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.secondary),
            )
        }
        if (uiState.notes.isEmpty()) {
            item {
                Text(
                    text = "No Notes yet",
                    modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.secondary),
                )
            }
        } else {
            items(uiState.notes.size) { noteIndex ->
                Text(
                    text = "Notes List Placeholder(index = ${noteIndex})",
                    modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.secondary),
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun NotesListScreenPreview() {
    NotesListScreen(NotesListUiState())
}