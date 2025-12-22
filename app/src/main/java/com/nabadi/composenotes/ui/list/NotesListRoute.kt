package com.nabadi.composenotes.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NotesListRoute(
    modifier: Modifier = Modifier,
    viewModel: NotesListViewModel = viewModel<NotesListViewModel>(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // No side-effects. Just read the current state snapshot.
    NotesListScreen(
        uiState = uiState,
        modifier = modifier,
    )
}