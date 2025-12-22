package com.nabadi.composenotes.ui.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NotesListScreen(
    state: NotesListState,
    modifier: Modifier = Modifier,
) {
    // Placeholder only. No UI polish.
    Text(
        text = "Notes List Placeholder(count = ${state.notes.size})",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun NotesListScreenPreview() {
    NotesListScreen(NotesListState())
}