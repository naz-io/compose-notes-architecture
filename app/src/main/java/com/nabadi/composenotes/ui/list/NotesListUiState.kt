package com.nabadi.composenotes.ui.list

import com.nabadi.composenotes.domain.Note

data class NotesListUiState(
    val isLoading: Boolean = false,
    val notes: List<Note> = emptyList(),
    val error: String? = null,
)