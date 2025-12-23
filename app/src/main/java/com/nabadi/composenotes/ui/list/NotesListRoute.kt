package com.nabadi.composenotes.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nabadi.composenotes.data.InMemoryNotesRepository

@Composable
fun NotesListRoute(
    modifier: Modifier = Modifier,
    viewModel: NotesListViewModel = viewModel<NotesListViewModel>(
        factory = NotesListViewModelFactory(InMemoryNotesRepository())
    ),
) {
    LaunchedEffect(Unit) {
        viewModel.loadNotes()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NotesListScreen(
        uiState = uiState,
        modifier = modifier,
    )
}