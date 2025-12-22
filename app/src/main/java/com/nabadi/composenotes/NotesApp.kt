package com.nabadi.composenotes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nabadi.composenotes.navigation.NotesNavGraph

@Composable
fun NotesApp(modifier: Modifier = Modifier) {
    NotesNavGraph(modifier = modifier)
}