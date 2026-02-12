package edu.ucne.marcos_rosario_ap2_p1.presentation.list

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ListScreen(
    viewModel: ListViewModel = hiltViewModel(),
    onDrawer: () -> Unit = {},
    onNavigateToCreate: () -> Unit,
    onNavigateToEdit: (Int) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

}

