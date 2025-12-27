package com.nabadi.composenotes.ui.list

import com.nabadi.composenotes.data.NotesRepository
import com.nabadi.composenotes.domain.Note
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test
import kotlin.collections.emptyList


class NotesListViewModelTest {

    private class FakeNotesRepository(
        private val notes: List<Note>
    ) : NotesRepository {
        override fun getNotes(): List<Note> = notes
    }

    @Test
    fun uiState_initial_then_contains_notes_after_loadNotes() {
        // Arrange
        val fakeNotes = listOf(
            Note(id = 1, title = "A", body = "Body A"),
            Note(id = 2, title = "", body = "Body B")
        )
        val viewModel = NotesListViewModel(
            notesRepository = FakeNotesRepository(fakeNotes)
        )

        // Assert initial state
        val initialUiState = viewModel.uiState.value
        assertEquals(false, initialUiState.isLoading)
        assertEquals(emptyList<Note>(), initialUiState.notes)
        assertNull(initialUiState.error)

        // Act
        viewModel.loadNotes()

        // Assert state after loadNotes()
        val finalUiState = viewModel.uiState.value
        assertEquals(false, finalUiState.isLoading)
        assertEquals(fakeNotes, finalUiState.notes)
        assertNull(finalUiState.error)
    }
}