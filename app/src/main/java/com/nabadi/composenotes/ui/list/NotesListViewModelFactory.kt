package com.nabadi.composenotes.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nabadi.composenotes.data.NotesRepository

// This factory exists because the ViewModel has constructor dependencies,
// and the platform cannot create such ViewModels on its own.
// This is intentionally manual and explicit:
// - no DI framework yet
// - no hidden wiring
// - no magic
// The goal is to keep construction visible at this stage so that
// lifecycle rules and ownership are easy to reason about.
// This factory is a temporary, honest solution — not an abstraction layer.
class NotesListViewModelFactory(
    private val repository: NotesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotesListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}
