package com.nabadi.composenotes.ui.list

import com.nabadi.composenotes.domain.Note

// This UI state exists as a single, explicit snapshot of everything the screen needs to render.
// The goal is not elegance or minimal fields — the goal is predictability.
// By keeping all render-relevant state here, recomposition becomes a pure rendering concern
// and cannot accidentally trigger behavior or work.
// If something affects what the user sees, it belongs here.
data class NotesListUiState(
    val isLoading: Boolean = false,
    val notes: List<Note> = emptyList(),
    val error: String? = null,
)