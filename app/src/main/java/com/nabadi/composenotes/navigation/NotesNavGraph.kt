package com.nabadi.composenotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nabadi.composenotes.ui.list.NotesListRoute

object Routes {
    // Single destination only
    const val NOTES_LIST = "notes_list"
}

@Composable
fun NotesNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NOTES_LIST,
        modifier = modifier
    ) {
        composable(Routes.NOTES_LIST) {
            NotesListRoute()
        }
    }
}