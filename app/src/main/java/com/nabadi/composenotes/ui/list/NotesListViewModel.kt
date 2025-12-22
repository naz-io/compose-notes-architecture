package com.nabadi.composenotes.ui.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class NotesListViewModel() : ViewModel() {
    private val _uiState: MutableStateFlow<NotesListUiState> = MutableStateFlow(NotesListUiState())
    var uiState: StateFlow<NotesListUiState> = _uiState.asStateFlow()
}