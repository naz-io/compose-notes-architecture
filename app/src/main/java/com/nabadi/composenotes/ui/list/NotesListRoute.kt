package com.nabadi.composenotes.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NotesListRoute(
    modifier: Modifier = Modifier,
    viewModel: NotesListViewModel = viewModel<NotesListViewModel>(),
) {
    // No side-effects. Just read the current state snapshot.
    NotesListScreen(
        uiState = viewModel.state,
        modifier = modifier,
    )
}