package com.nabadi.composenotes.ui.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nabadi.composenotes.R
import com.nabadi.composenotes.domain.Note
import com.nabadi.composenotes.ui.theme.ComposeNotesArchitectureTheme

@Composable
fun NotesListScreen(
    uiState: NotesListUiState,
    modifier: Modifier = Modifier,
) {
    when {
        uiState.isLoading -> {
            LoadingState(modifier)
        }

        uiState.error != null -> {
            ErrorState(
                message = uiState.error,
                modifier = modifier
            )
        }

        uiState.notes.isEmpty() -> {
            EmptyState(modifier)
        }

        else -> {
            NotesContent(
                notes = uiState.notes,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun LoadingState(modifier: Modifier) {
    val screenPadding = dimensionResource(id = R.dimen.screen_padding)
    Text(
        text = "Loading…",
        modifier = modifier
            .fillMaxSize()
            .padding(screenPadding)
    )
}

@Composable
private fun ErrorState(
    message: String,
    modifier: Modifier
) {
    val screenPadding = dimensionResource(id = R.dimen.screen_padding)
    Text(
        text = "Error: $message",
        modifier = modifier
            .fillMaxSize()
            .padding(screenPadding)
    )
}

@Composable
private fun EmptyState(modifier: Modifier) {
    val screenPadding = dimensionResource(id = R.dimen.screen_padding)
    Text(
        text = "No notes yet",
        modifier = modifier
            .fillMaxSize()
            .padding(screenPadding)
    )
}

@Composable
private fun NotesContent(
    notes: List<Note>,
    modifier: Modifier
) {
    val screenPadding = dimensionResource(id = R.dimen.screen_padding)
    val itemSpacing = dimensionResource(id = R.dimen.item_spacing)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(screenPadding)
    ) {
        item {
            Text(
                text = stringResource(R.string.notes_list_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        items(
            items = notes,
            key = { it.id } // important for stability
        ) { note ->
            Text(
                text = note.title.ifBlank { "(untitled)" },
                modifier = Modifier.padding(vertical = itemSpacing)
            )
        }
    }
}


@Preview(name = "Loading", showBackground = true)
@Composable
private fun NotesListScreenPreview_Loading() {
    ComposeNotesArchitectureTheme {
        NotesListScreen(
            uiState = NotesListUiState(isLoading = true)
        )
    }
}

@Preview(name = "Error", showBackground = true)
@Composable
private fun NotesListScreenPreview_Error() {
    ComposeNotesArchitectureTheme {
        NotesListScreen(
            uiState = NotesListUiState(error = "Error loading notes")
        )
    }
}

@Preview(name = "Empty", showBackground = true)
@Composable
private fun NotesListScreenPreview_Empty() {
    ComposeNotesArchitectureTheme {
        NotesListScreen(
            uiState = NotesListUiState(notes = emptyList())
        )
    }
}

@Preview(name = "Content", showBackground = true)
@Composable
private fun NotesListScreenPreview_Content() {
    ComposeNotesArchitectureTheme {
        NotesListScreen(
            uiState = NotesListUiState(notes = previewNotes)
        )
    }
}

@Preview(
    name = "Content (Dark)",
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun NotesListScreenPreview_Content_Dark() {
    ComposeNotesArchitectureTheme {
        NotesListScreen(
            uiState = NotesListUiState(notes = previewNotes)
        )
    }
}


private val previewNotes = listOf(
    Note(id = 1, title = "Groceries", body = "Milk, eggs, bread"),
    Note(id = 2, title = "", body = "No title note (should show '(untitled)')"),
    Note(
        id = 3,
        title = "Long title that should wrap or truncate depending on UI decisions later",
        body = "Long body..."
    )
)
