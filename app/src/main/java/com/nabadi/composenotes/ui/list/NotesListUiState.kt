package com.nabadi.composenotes.ui.list

import com.nabadi.composenotes.domain.Note

data class NotesListUiState(
    val notes: List<Note> = emptyList(),
)