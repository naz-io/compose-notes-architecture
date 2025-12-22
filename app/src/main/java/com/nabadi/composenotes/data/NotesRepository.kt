package com.nabadi.composenotes.data

import com.nabadi.composenotes.domain.Note

interface NotesRepository {
    fun getNotes(): List<Note>
}