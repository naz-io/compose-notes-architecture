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

    // This function performs exactly one unit of work: load notes once and publish the result.
    // It is intentionally synchronous and side-effect free beyond state updates.
    // There is no retry logic, no coroutine launching, and no defensive checks here
    // because timing and repetition are controlled by the caller (the UI boundary),
    // not hidden inside the ViewModel.
    // This keeps "when work happens" visible and testable.
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