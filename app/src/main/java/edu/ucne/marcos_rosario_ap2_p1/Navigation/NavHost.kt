package edu.ucne.marcos_rosario_ap2_p1.Navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.marcos_rosario_ap2_p1.presentation.edit.EditScreen
import edu.ucne.marcos_rosario_ap2_p1.presentation.edit.ViewModel
import edu.ucne.marcos_rosario_ap2_p1.presentation.list.ListScreen
import edu.ucne.marcos_rosario_ap2_p1.presentation.list.ListViewModel

@Composable
fun MainNavHost(
    navHostController: NavHostController
) {
    val listViewModel: ListViewModel = hiltViewModel()

    NavHost(
        navController = navHostController,
        startDestination = Screen.ListScreen
    ) {
        composable<Screen.ListScreen> {
            ListScreen(
                viewModel = listViewModel,
                onNavigateToCreate = {
                    navHostController.navigate(Screen.EditScreen(0))
                },
                onNavigateToEdit = { id ->
                    navHostController.navigate(Screen.EditScreen(id))
                }
            )
        }

        composable<Screen.EditScreen> {
            val viewModel: ViewModel = hiltViewModel()

            EditScreen(
                viewModel = viewModel,
                onNavigateBack = {
                    viewModel.resetSavedStatus()
                    navHostController.navigateUp()
                },
            )
        }
    }
}

