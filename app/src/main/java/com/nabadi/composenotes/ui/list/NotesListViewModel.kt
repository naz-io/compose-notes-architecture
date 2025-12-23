package com.nabadi.composenotes.ui.list

import androidx.lifecycle.ViewModel
import com.nabadi.composenotes.data.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class NotesListViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<NotesListUiState> = MutableStateFlow(NotesListUiState())
    val uiState: StateFlow<NotesListUiState> = _uiState.asStateFlow()

    fun loadNotes() {
        _uiState.value = NotesListUiState(isLoading = true)

        val notes = notesRepository.getNotes()

        _uiState.value = NotesListUiState(
            isLoading = false,
            notes = notes,
            error = null
        )
    }
}