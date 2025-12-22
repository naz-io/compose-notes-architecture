package com.nabadi.composenotes.ui.list

import androidx.lifecycle.ViewModel
import com.nabadi.composenotes.domain.Note

data class NotesListState(
    val notes: List<Note> = emptyList(),
)

class NotesListViewModel() : ViewModel() {
    var state: NotesListState = NotesListState()
}