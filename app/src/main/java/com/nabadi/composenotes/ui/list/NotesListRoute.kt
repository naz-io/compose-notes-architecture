package com.nabadi.composenotes.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nabadi.composenotes.data.InMemoryNotesRepository

// This composable is intentionally a "Route":
// it owns lifecycle awareness, side-effects, and ViewModel wiring.
// It does not render UI directly and it does not contain business logic.
// The purpose of this boundary is to keep rendering pure and
// make the timing of work explicit.
// If side-effects or wiring move out of here, the architecture has regressed.
@Composable
fun NotesListRoute(
    modifier: Modifier = Modifier,
    viewModel: NotesListViewModel = viewModel<NotesListViewModel>(
        factory = NotesListViewModelFactory(InMemoryNotesRepository())
    ),
) {
    // This side-effect lives here, not in the screen, not in UI elements,
    // and not in the ViewModel, because this is where lifecycle meets intent.
    LaunchedEffect(Unit) {
        viewModel.loadNotes()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NotesListScreen(
        uiState = uiState,
        modifier = modifier,
    )
}