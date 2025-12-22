package com.nabadi.composenotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nabadi.composenotes.ui.list.NotesListRoute

@Composable
fun NotesNavGraph(modifier: Modifier = Modifier) {
    // Single destination only
    NotesListRoute(modifier = modifier)
}